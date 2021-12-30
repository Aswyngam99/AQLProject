package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class Operation implements Initializable {
    @FXML
    private Text HoursInput;

    @FXML
    private Text MinutesInput;

    @FXML
    private Text SecondsInput;

    Map<Integer, String> numberMap;
    Integer currSeconds;
    Thread thrd;
    Integer hmsToSeconds(Integer h, Integer m, Integer s){
        Integer hToseconds = h*3600;
        Integer mToseconds = m*60;
        Integer total = hToseconds + mToseconds + s;
        return total;
    }
    LinkedList <Integer> secondsToHms(Integer currSeconds){

        Integer Hours = currSeconds/3600;
        currSeconds = currSeconds%3600;
        Integer Minutes = currSeconds/60;
        currSeconds = currSeconds%60;
        Integer Seconds = currSeconds;
        LinkedList <Integer> answer = new LinkedList<Integer>();
        answer.add(Hours);
        answer.add(Minutes);
        answer.add(Seconds);
        return answer;
    }
    public void Start(javafx.event.ActionEvent event) {
        numberMap = new TreeMap<Integer, String>();

        for(Integer i=0; i<=60; i++){
            if(i >= 0 && i <=9 ){
                numberMap.put(i,"0" + i.toString());
            }else{
                numberMap.put(i,i.toString());
            }
        }
        currSeconds = hmsToSeconds(1,4,60);
    }
    void setOutput(){
        LinkedList<Integer> currHms = secondsToHms(currSeconds);
        //System.out.println(currHms.get(0) + "-" + currHms.get(1) + "-" + currHms.get(2));
        HoursInput.setText(numberMap.get(currHms.get(0)));
        MinutesInput.setText(numberMap.get(currHms.get(1)));
        SecondsInput.setText(numberMap.get(currHms.get(2)));
    }
    void StartCountDown(){
        thrd = new Thread(new Runnable() {
            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                try{
                    while(true){
                        //countDown
                        setOutput();

                        if(currSeconds == 0){
                            thrd.stop();
                        }
                        currSeconds = currSeconds - 1;
                        Thread.sleep(1000);

                    }
                }catch (Exception e){

                }
            }
        });
        thrd.start();
    }
    public void Button(javafx.event.ActionEvent actionEvent){
        System.out.println("Starting CountDown...");
        StartCountDown();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Integer> HoursList = FXCollections.observableArrayList();
        ObservableList<Integer> MinutesAndSecondsList = FXCollections.observableArrayList();
        for(int i=0; i<=60; i++){
            if(i >= 0 && i <=24 ){
                HoursList.add(new Integer(i));
            }
            MinutesAndSecondsList.add(new Integer(i));
        }
    }
}

