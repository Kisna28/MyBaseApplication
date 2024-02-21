package com.core.extension

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.os.Build
import android.util.TypedValue
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit


/**
 * Created by Shwet Desai on 14/12/23.
 * All rights reserved.
 * shwet.desai0@gmail.com
 */


fun AppCompatActivity.openFragmentCommit(container: Int, fragment: Fragment) {
    supportFragmentManager.commit {
        replace(container, fragment)
    }
}

fun Fragment.openFragmentCommit(container: Int, fragment: Fragment) {
    childFragmentManager.commit {
        replace(container, fragment)
    }
}

fun Fragment.openFragmentCommitAndAddToBackStack(container: Int, fragment: Fragment) {
    childFragmentManager.commit {
        replace(container, fragment)
        addToBackStack("addBackStack")
    }
}

fun AppCompatActivity.addFragmentCommit(container: Int, fragment: Fragment) {
    supportFragmentManager.commit {
        add(container, fragment)
    }
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    this.context?.showToast(message, duration)
}

fun Context.getColorByThemeAttr(attr: Int, defaultColor: Int): Int {
    val typedValue = TypedValue()
    val got: Boolean = theme.resolveAttribute(attr, typedValue, true)
    return if (got) typedValue.data else defaultColor
}


/**
 * Initializes the camera and storage permissions setup.
 * Centralized utility function for managing multiple permissions required across different screens.
 * This function abstracts the complexity of permission checks and accommodates Android version-specific changes.
 * Team should use this method for handling permissions to ensure consistency and ease of maintenance.
 *
 * @param onAllPermissionsGranted Callback function to execute when all required permissions are granted.
 * @param requestPermissionLauncher ActivityResultLauncher for launching the permission request. This is only used for composable screens
 */
fun Activity.initiateCameraPermissionSetup(
    requestCodeForNonComposableScreen: Int = Activity.RESULT_CANCELED,
    requestPermissionLauncher: ActivityResultLauncher<Array<String>>?= null,
    onAllPermissionsGranted: () -> Unit,
) {
    val isCameraPermitted = isPermissionGrantedFor(Manifest.permission.CAMERA)
    val isImageReadPermitted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        isPermissionGrantedFor(Manifest.permission.READ_MEDIA_IMAGES)
    } else {
        true
    }
    val isStoragePermitted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        true
    } else {
        isPermissionGrantedFor(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    if (isCameraPermitted && isStoragePermitted && isImageReadPermitted) {
        onAllPermissionsGranted()
    } else {
        val permissionToRequest: Array<String> = when {
            !isCameraPermitted && !isStoragePermitted && !isImageReadPermitted -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_MEDIA_IMAGES
                    )
                } else {
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }

            !isCameraPermitted -> {
                arrayOf(Manifest.permission.CAMERA)
            }

            !isImageReadPermitted -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    arrayOf(Manifest.permission.READ_MEDIA_IMAGES)
                } else {
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }

            else -> {
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
        if (requestPermissionLauncher != null) {
            requestPermissionLauncher.launch(permissionToRequest)
        } else {
            ActivityCompat.requestPermissions(
                this, permissionToRequest,
                requestCodeForNonComposableScreen
            )
        }
    }
}

private fun Context.isPermissionGrantedFor(permissionID: String): Boolean {
    return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(
        this,
        permissionID
    )
}

fun Context.getActivityForPermission(): Activity = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.getActivityForPermission()
    else -> throw IllegalStateException("$this is not the activity")
}
