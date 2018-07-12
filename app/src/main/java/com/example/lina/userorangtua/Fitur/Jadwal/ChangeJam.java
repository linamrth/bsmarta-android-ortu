package com.example.lina.userorangtua.Fitur.Jadwal;

public class ChangeJam {
    private String jam;

    public ChangeJam(String jam) {
        this.jam = jam;
    }

    public String getJam() {
        if(jam.equals("1")){
            jam = "10.00 - 11.00";
        } else if (jam.equals("2") ){
            jam = "11.00 - 12.00";
        } else if (jam.equals("3")){
            jam = "13.00 - 14.00";
        } else if (jam.equals("4")){
            jam = "14.00 - 15.00";
        } else if (jam.equals("5")){
            jam = "15.00 - 16.00";
        } else if (jam.equals("6")){
            jam = "16.00 - 17.00";
        } else if (jam.equals("7")){
            jam  = "18.00 - 19.00";
        }

        return jam;
    }

    public String getJamNoSpace() {
        if(jam.equals("1")){
            jam = "10";
        } else if (jam.equals("2") ){
            jam = "11";
        } else if (jam.equals("3")){
            jam = "13";
        } else if (jam.equals("4")){
            jam = "14";
        } else if (jam.equals("5")){
            jam = "15";
        } else if (jam.equals("6")){
            jam = "16";
        } else if (jam.equals("7")){
            jam = "18";
        }

        return jam;
    }
}
