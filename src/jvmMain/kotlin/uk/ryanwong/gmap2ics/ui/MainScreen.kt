/*
 * Copyright (c) 2022. Ryan Wong (hello@ryanwong.co.uk)
 */

package uk.ryanwong.gmap2ics.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uk.ryanwong.gmap2ics.app.models.JFileChooserResult
import uk.ryanwong.gmap2ics.ui.components.CheckBoxItem
import uk.ryanwong.gmap2ics.ui.components.ErrorAlertDialog
import uk.ryanwong.gmap2ics.ui.components.PathPickerItem
import uk.ryanwong.gmap2ics.ui.viewmodels.MainScreenViewModel
import java.util.Locale
import java.util.ResourceBundle.getBundle
import javax.swing.JFileChooser
import javax.swing.UIManager

@Composable
fun mainScreen(
    onCloseRequest: () -> Unit,
    mainScreenViewModel: MainScreenViewModel
) {
    val resourceBundle = getBundle("resources", Locale.ENGLISH)

    Window(
        onCloseRequest = onCloseRequest,
        title = resourceBundle.getString("gmap2ical.google.maps.to.ical"),
        state = rememberWindowState(width = 800.dp, height = 560.dp)
    ) {
        val coroutineScope = rememberCoroutineScope()
        val uiState by mainScreenViewModel.mainScreenUIState.collectAsState()
        val statusMessage by mainScreenViewModel.statusMessage.collectAsState()
        val jsonPath by mainScreenViewModel.jsonPath.collectAsState()
        val iCalPath by mainScreenViewModel.iCalPath.collectAsState()
        val exportPlaceVisit by mainScreenViewModel.exportPlaceVisit.collectAsState()
        val exportActivitySegment by mainScreenViewModel.exportActivitySegment.collectAsState()
        val enablePlacesApiLookup by mainScreenViewModel.enablePlacesApiLookup.collectAsState()

        when (uiState) {
            is MainScreenUIState.ChangeJsonPath -> {
                coroutineScope.launch {
                    val jFileChooserResult = chooseDirectorySwing(
                        dialogTitle = resourceBundle.getString("json.source.location"),
                        currentDirectoryPath = jsonPath
                    )
                    mainScreenViewModel.updateJsonPath(jFileChooserResult = jFileChooserResult)
                }
            }

            is MainScreenUIState.ChangeICalPath -> {
                coroutineScope.launch {
                    val jFileChooserResult = chooseDirectorySwing(
                        dialogTitle = resourceBundle.getString("ical.output.location"),
                        currentDirectoryPath = iCalPath
                    )
                    mainScreenViewModel.updateICalPath(jFileChooserResult = jFileChooserResult)
                }
            }

            is MainScreenUIState.Error -> {
                ErrorAlertDialog(
                    text = (uiState as MainScreenUIState.Error).errMsg,
                    onDismissRequest = { mainScreenViewModel.notifyErrorMessageDisplayed() }
                )
            }

            else -> {}
        }

        MaterialTheme {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = resourceBundle.getString("google.maps.to.ical.converter"),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth()
                        .padding(vertical = 24.dp),
                )

                Row(
                    modifier = Modifier.fillMaxWidth()
                        .weight(weight = 1f, fill = true)
                ) {
                    SettingsColumn(
                        jsonPath = jsonPath,
                        iCalPath = iCalPath,
                        exportPlaceVisit = exportPlaceVisit,
                        exportActivitySegment = exportActivitySegment,
                        enablePlacesApiLookup = enablePlacesApiLookup,
                        onExportPlaceVisitChanged = { enabled -> mainScreenViewModel.setExportPlaceVisit(enabled) },
                        onExportActivitySegmentChanged = { enabled ->
                            mainScreenViewModel.setExportActivitySegment(enabled)
                        },
                        onEnablePlaceApiLookupChanged = { enabled ->
                            mainScreenViewModel.setEnablePlacesApiLookup(enabled)
                        },
                        onChangeJsonPath = { mainScreenViewModel.onChangeJsonPath() },
                        onChangeICalPath = { mainScreenViewModel.onChangeICalPath() },
                        modifier = Modifier.weight(weight = 0.5f, fill = true)
                    )

                    StatusColumn(
                        statusMessage = statusMessage,
                        modifier = Modifier.weight(weight = 0.5f, fill = true)
                    )
                }

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Button(
                        shape = MaterialTheme.shapes.small,
                        onClick = { mainScreenViewModel.startConversion() }
                    ) {
                        Text(
                            text = resourceBundle.getString("convert"),
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                    Button(
                        shape = MaterialTheme.shapes.small,
                        onClick = onCloseRequest
                    ) {
                        Text(
                            text = resourceBundle.getString("exit.app"),
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SettingsColumn(
    jsonPath: String,
    iCalPath: String,
    exportPlaceVisit: Boolean,
    exportActivitySegment: Boolean,
    enablePlacesApiLookup: Boolean,
    onExportPlaceVisitChanged: (Boolean) -> Unit,
    onExportActivitySegmentChanged: (Boolean) -> Unit,
    onEnablePlaceApiLookupChanged: (Boolean) -> Unit,
    onChangeJsonPath: () -> Unit,
    onChangeICalPath: () -> Unit,
    modifier: Modifier = Modifier
) {
    val resourceBundle = getBundle("resources", Locale.ENGLISH)

    val spacerModifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(vertical = 16.dp)
        .height(height = 1.dp)
        .background(color = Color.Gray)

    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        PathPickerItem(
            title = resourceBundle.getString("json.path"),
            currentPath = jsonPath,
            onClick = onChangeJsonPath,
            resourceBundle = resourceBundle
        )

        PathPickerItem(
            title = resourceBundle.getString("ical.path"),
            currentPath = iCalPath,
            onClick = onChangeICalPath,
            resourceBundle = resourceBundle
        )

        Spacer(modifier = spacerModifier)

        CheckBoxItem(
            text = resourceBundle.getString("export.places.visited"),
            checked = exportPlaceVisit,
            onCheckedChange = onExportPlaceVisitChanged
        )

        CheckBoxItem(
            text = resourceBundle.getString("export.activity.segments"),
            checked = enablePlacesApiLookup,
            onCheckedChange = onEnablePlaceApiLookupChanged
        )

        Spacer(modifier = spacerModifier)

        CheckBoxItem(
            text = resourceBundle.getString("enable.places.api.lookup"),
            checked = exportActivitySegment,
            onCheckedChange = onExportActivitySegmentChanged
        )
    }
}

@Composable
private fun StatusColumn(
    statusMessage: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(color = Color.White)
            .scrollable(
                enabled = true,
                orientation = Orientation.Vertical,
                state = rememberScrollState()
            )
    ) {
        statusMessage.forEach { message ->
            Text(
                text = message,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun StatusColumnPreview() {
    MaterialTheme {
        StatusColumn(
            statusMessage = listOf("some very very very very very very very very very very very very very very very very very very very very  long text"),
        )
    }
}

private suspend fun chooseDirectorySwing(dialogTitle: String, currentDirectoryPath: String): JFileChooserResult =
    withContext(Dispatchers.IO) {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

        val chooser = JFileChooser(currentDirectoryPath).apply {
            fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
            isVisible = true
            this.dialogTitle = dialogTitle
        }

        return@withContext when (val returnCode = chooser.showOpenDialog(null)) {
            JFileChooser.APPROVE_OPTION -> JFileChooserResult.AbsolutePath(absolutePath = chooser.selectedFile.absolutePath)
            JFileChooser.CANCEL_OPTION -> JFileChooserResult.Cancelled
            else -> JFileChooserResult.Error(errorCode = returnCode)
        }
    }