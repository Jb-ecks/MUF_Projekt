package com.example.muf_projekt_v11;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Binder;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.muf_projekt_v11.data.DatenInformation;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // TODO : Zeile 44 Frequenz noch über Dateninfo einsetzen
    //  Stop schreiben
    //  alles binden
    final LiveData<DatenInformation>  datenLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        datenLiveData =new DatenLiveData(application);
    }

    private final class DatenLiveData extends LiveData<DatenInformation> {
        private final DatenInformation datenInformation = new DatenInformation();
        private SensorManager sm;
        private MockSensor mockSensor;
        private MockSensor.SensorListener  listener = new MockSensor.SensorListener(){

            @Override
            public void onSensorData(String[] record) {
                datenInformation.setDatenframe(record);
                datenInformation.setP1(Float.parseFloat(record[0]));
                datenInformation.setP2(Float.parseFloat(record[1]));
                datenInformation.setP3(Float.parseFloat(record[2]));
                datenInformation.setP4(Float.parseFloat(record[3]));
            }
        };

        DatenLiveData(Application application){
            mockSensor.start(application.getApplicationContext(),20,listener);
        }
    }


        public static class MockSensor extends Activity {
            public void start(
                    Context c, long intervalMs, SensorListener l) {
                Thread t = new Thread(() -> {
                    List<String[]> tempdaten = new readCsvData(
                            getResources().openRawResource(R.raw.daten)
                    ).read();
                    // in for schleife simulieren
                    for (String[] record : tempdaten) {
                        l.onSensorData(record);
                        try {
                            Thread.sleep(intervalMs);
                        } catch (InterruptedException e) {
                        }
                    }
                });
                t.start();
            }

            public void stop() {
                // TODO: implement!
            }

            public interface SensorListener {
                void onSensorData(String[] record);
            }
        }

}



