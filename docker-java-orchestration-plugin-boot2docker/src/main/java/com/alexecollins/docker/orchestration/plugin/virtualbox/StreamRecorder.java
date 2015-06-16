package com.alexecollins.docker.orchestration.plugin.virtualbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class StreamRecorder extends Thread {

    private InputStream is;
    private String type;

    private StringBuilder sb = new StringBuilder();

    StreamRecorder(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    public void run() {

        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String toString() {
        return sb.toString();
    }
}