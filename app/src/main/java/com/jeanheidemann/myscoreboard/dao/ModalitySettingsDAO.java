package com.jeanheidemann.myscoreboard.dao;

import android.content.Context;

import com.jeanheidemann.myscoreboard.entity.ModalitySettings;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jean.heidemann on 12/05/2016.
 */
public class ModalitySettingsDAO {
    public void saveModalitySettings(ModalitySettings settings, Context context) throws IOException {
        FileOutputStream fOut = context.openFileOutput("Modality_Futebol.xml", context.MODE_PRIVATE);
        fOut.write(settings.toXml().getBytes());
        fOut.close();
    }
}
