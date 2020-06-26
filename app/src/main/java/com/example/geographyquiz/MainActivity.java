package com.example.geographyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView title, question, score, infoText;
    Button startButton, viewMapButton, backButton, optionOne, optionTwo, optionThree, optionFour, nextButton, mainMenuButton;
    ImageView map;
    GridLayout gridLayout;
    int count, questionCount, scoreCount;

    public void startQuiz(View view){
        disable();
        score.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        enable();
        count = 0;
        questionCount = 0;
        scoreCount = 0;
    }

    public void viewMap(View view){
        disable();
        map.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.VISIBLE);
    }

    public void backToMainMenu(View view){

        mainMenuButton.setVisibility(View.INVISIBLE);
        title.setText("Geography Quiz");
        startButton.setVisibility(View.VISIBLE);
        viewMapButton.setVisibility(View.VISIBLE);
        score.setText("Score: 0/0");
        nextButton.setText("NEXT");
        question.setText("Q1: What is the capital of West Bengal?");
        optionOne.setText("Siliguri");
        optionTwo.setText("Purulia");
        optionThree.setText("Kolkata");
        optionFour.setText("Durgapur");
        infoText.setText("Also known as the Cultural Capital of India. Purulia, Siliguri, Digha, Durgapur, Asansol, Darjeeling, Kharagpur and Shantiniketan are few places in West Bengal.");
    }

    public void optionClicked(View view){
        int tag = Integer.parseInt(view.getTag().toString());
        optionOne.setClickable(false);
        optionTwo.setClickable(false);
        optionThree.setClickable(false);
        optionFour.setClickable(false);
        check(tag);



        questionCount++;
        score.setText("Score: " + Integer.toString(scoreCount) + "/" + Integer.toString(questionCount));
        infoText.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        count++;
        if(count == 30){
            nextButton.setText("RESULT");
        }
    }

    public void nextClicked(View view){
        if(count != 30) {
            infoText.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            enable();
            update();
        }
        else{
            infoText.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            gridLayout.setVisibility(View.INVISIBLE);
            question.setVisibility(View.INVISIBLE);
            score.setVisibility(View.INVISIBLE);
            if(scoreCount > 22){
                title.setText("Final score: " + Integer.toString(scoreCount) + "/30\nPassed!!! :D");
                title.setVisibility(View.VISIBLE);
            }
            else{
                title.setText("Final score: " + Integer.toString(scoreCount) + "/30\nFailed!!! :(");
                title.setVisibility(View.VISIBLE);
            }

            mainMenuButton.setVisibility(View.VISIBLE);
        }

    }

    public void backButton(View view){
        map.setVisibility(View.INVISIBLE);
        backButton.setVisibility(View.INVISIBLE);
        title.setVisibility(View.VISIBLE);
        startButton.setVisibility(View.VISIBLE);
        viewMapButton.setVisibility(View.VISIBLE);


    }

    public void enable(){
        optionOne.setBackgroundResource(android.R.drawable.btn_default);
        optionTwo.setBackgroundResource(android.R.drawable.btn_default);
        optionThree.setBackgroundResource(android.R.drawable.btn_default);
        optionFour.setBackgroundResource(android.R.drawable.btn_default);
        nextButton.setBackgroundResource(android.R.drawable.btn_default);

        optionOne.setClickable(true);
        optionTwo.setClickable(true);
        optionThree.setClickable(true);
        optionFour.setClickable(true);

    }

    public void disable(){
        title.setVisibility(View.INVISIBLE);
        startButton.setVisibility(View.INVISIBLE);
        viewMapButton.setVisibility(View.INVISIBLE);
    }

    public void check(int tag){
        switch (count){

            case 0:
                optionThree.setBackgroundColor(Color.GREEN);
                if(tag == 3) scoreCount++;
                if(tag != 3){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 1:
                optionTwo.setBackgroundColor(Color.GREEN);
                if(tag == 2) scoreCount++;
                if(tag != 2){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 2:
                optionTwo.setBackgroundColor(Color.GREEN);
                if(tag == 2) scoreCount++;
                if(tag != 2){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 3:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;
            case 4:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 5:
                optionThree.setBackgroundColor(Color.GREEN);
                if(tag == 3) scoreCount++;
                if(tag != 3){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 6:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 7:
                optionThree.setBackgroundColor(Color.GREEN);
                if(tag == 3) scoreCount++;
                if(tag != 3){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 8:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 9:
                optionTwo.setBackgroundColor(Color.GREEN);
                if(tag == 2) scoreCount++;
                if(tag != 2){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 10:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 11:
                optionFour.setBackgroundColor(Color.GREEN);
                if(tag == 4) scoreCount++;
                if(tag != 4){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionThree.setBackgroundColor(Color.RED);
                }
                break;

            case 12:
                optionFour.setBackgroundColor(Color.GREEN);
                if(tag == 4) scoreCount++;
                if(tag != 4){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionThree.setBackgroundColor(Color.RED);
                }
                break;

            case 13:
                optionThree.setBackgroundColor(Color.GREEN);
                if(tag == 3) scoreCount++;
                if(tag != 3){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 14:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 15:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 16:
                optionThree.setBackgroundColor(Color.GREEN);
                if(tag == 3) scoreCount++;
                if(tag != 3){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 17:
                optionTwo.setBackgroundColor(Color.GREEN);
                if(tag == 2) scoreCount++;
                if(tag != 2){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 18:
                optionThree.setBackgroundColor(Color.GREEN);
                if(tag == 3) scoreCount++;
                if(tag != 3){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 19:
                optionFour.setBackgroundColor(Color.GREEN);
                if(tag == 4) scoreCount++;
                if(tag != 4){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionThree.setBackgroundColor(Color.RED);
                }
                break;

            case 20:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 21:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 22:
                optionFour.setBackgroundColor(Color.GREEN);
                if(tag == 4) scoreCount++;
                if(tag != 4){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionThree.setBackgroundColor(Color.RED);
                }
                break;

            case 23:
                optionFour.setBackgroundColor(Color.GREEN);
                if(tag == 4) scoreCount++;
                if(tag != 4){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionThree.setBackgroundColor(Color.RED);
                }
                break;

            case 24:
                optionTwo.setBackgroundColor(Color.GREEN);
                if(tag == 2) scoreCount++;
                if(tag != 2){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 25:
                optionFour.setBackgroundColor(Color.GREEN);
                if(tag == 4) scoreCount++;
                if(tag != 4){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionThree.setBackgroundColor(Color.RED);
                }
                break;

            case 26:
                optionThree.setBackgroundColor(Color.GREEN);
                if(tag == 3) scoreCount++;
                if(tag != 3){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 27:
                optionThree.setBackgroundColor(Color.GREEN);
                if(tag == 3) scoreCount++;
                if(tag != 3){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 28:
                optionTwo.setBackgroundColor(Color.GREEN);
                if(tag == 2) scoreCount++;
                if(tag != 2){
                    if(tag == 1) optionOne.setBackgroundColor(Color.RED);
                    else if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;

            case 29:
                optionOne.setBackgroundColor(Color.GREEN);
                if(tag == 1) scoreCount++;
                if(tag != 1){
                    if(tag == 3) optionThree.setBackgroundColor(Color.RED);
                    else if(tag == 2) optionTwo.setBackgroundColor(Color.RED);
                    else optionFour.setBackgroundColor(Color.RED);
                }
                break;




        }



    }

    public void update(){
        Log.i("update", Integer.toString(count));
        final String[][] info = new String[][]{
                {"Q1: What is the capital of West Bengal?", "Siliguri", "Purulia", "Kolkata", "Durgapur", "Also known as the Cultural Capital of India. Purulia, Siliguri, Digha, Durgapur, Asansol, Darjeeling, Kharagpur and Shantiniketan are few places in West Bengal."},
                {"Q2: What is the capital of Tamil Nadu?", "Coimbatore", "Chennai", "Madurai", "Vellore", "Coimbatore, Madurai, Vellore, Ooty, Mahabalipuram, Tiruchirappalli and Rameswaram are few places in Tamil Nadu."},
                {"Q3: What is the capital of Odisha?", "Puri", "Bhubaneswar", "Cuttack", "Rourkela", "This state is famous for it's centuries-old temples. Puri, Cuttack, Rourkela, Gopalpur, Bhadrak, Konark, Khordha and Keonjhar are few places in Odisha, formerly known as Orissa."},
                {"Q4: What is the capital of Karnataka?", "Bengaluru", "Mangalore", "Mysore", "Hampi", "Mangalore, Mysore, Hampi, Belur, Vijayapura and Belgaum are few places in Karnataka."},
                {"Q5: What is the capital of Telangana?", "Hyderabad", "Warangal", "Secunderabad", "Nizamabad", "Warangal, Secunderabad, Nizamabad and Bhevanagiri are few places in Telangana. This state was recently formed by splitting Andhra Pradesh."},
                {"Q6: What is the capital of Kerala?", "Kochi", "Kozhikode", "Trivandrum", "Munnar", "Munnar, Kozhikode, Kochi, Kovalam, Thalassery, Kollam and Alappuzha are few places in Kerala, formerly known as Orissa."},
                {"Q7: What is the capital of Madhya Pradesh?", "Bhopal", "Indore", "Gwalior", "Ujjain", "Indore, Ujjain, Gwalior, Jabalpur, Khandwa, Khajuraho and Chanderi are few places in Madhya Pradesh."},
                {"Q8: What is the capital of Bihar?", "Gaya", "Nalanda", "Patna", "Rajgir", "This is the state where Buddhism began. Gaya, Rajgir, Nalanda, Buxar, Bihar Sharif, Sonepur and Sasaram are few places in Bihar."},
                {"Q9: What is the capital of Rajastan?", "Jaipur", "Udaipur", "Jodhpur", "Ajmer", "The largest state in India. Udaipur, Jodhpur, Ajmer, Jaisalmer, Bikaner, Kota, Pushkar, Deogarh, Fatehpur and Pilani are few places in Rajasthan."},
                {"Q10: What is the capital of Assam?", "Guwahati", "Dispur", "Silchar", "Golaghat", "Guwahati, Silchar, Golaghat, Tezpur, Nagaon, Dhubri and Karimganj are few places in Assam."},
                {"Q11: What is the capital of Uttar Pradesh?", "Lucknow", "Kanpur", "Meerut", "Varanasi", "Home to one of the seven wonders of the world, The Taj Mahal in Agra. Kanpur, Meerut, Varanasi, Prayagraj, Bareilly, Aligarh, Jhansi, Ayodhya, Mathura, Noida and Ghaziabad are few places in Uttar Pradesh."},
                {"Q12: What is the capital of Maharashtra?", "Pune", "Thane", "Nagpur", "Mumbai", "Pune, Nagpur, Aurangabad, Nashik, Thane, Mahabaleshwar, Lonavla and Alibag are few places in Maharashtra."},
                {"Q13: What is the capital of Punjab?", "Ludhiana", "Amritsar", "Patiala", "Chandigarh", "Ludhiana, Amritsar, Patiala, Jalandhar, Pathankot, Bathinda and Firozpur are few places in Punjab."},
                {"Q14: What is the capital of Haryana?", "Panipat", "Gurugram", "Chandigarh", "Sonipat", "Chandigarh is the capital of both Punjab and Haryana, and also an Union Territory. Panipat, Sonipat, Gurugram, Faridabad, Rohtak and Jhajjar are few places in Haryana."},
                {"Q15: What is the capital of Sikkim?", "Gangtok", "Rangpo", "Lachung", "Pelling", "Namchi, Pelling, Lachung, Rangpo, Ranipool, Namthang, Thangu Valley and Phodong are few places in Sikkim."},
                {"Q16: What is the capital of Goa?", "Panaji", "Margao", "Vasco da Gama", "Goa Velha", "The smallest state in India. Margao, Vasco da Gama, Goa Velha, Mormugao and Canacona are few places in Goa."},
                {"Q17: What is the capital of Andhra Pradesh?", "Vizag", "Guntur", "Amaravati", "Vijayawada", "This state is the biggest exporter of rice in India. Hence, the name: Rice Bowl of India. Vizag or Visakhapatnam, Vijayawada, Tirupati, Guntur, Kakinada, Rajahmundry, Nellore and Kurnool are few places in Andhra Pradesh."},
                {"Q18: What is the capital of Chhattisgarh?", "Bhilai", "Raipur", "Raigarh", "Bilaspur", "This state is historically rich with forts and caves. It produces a huge source of electricity for the country. Bilaspur, Bhilai, Raigarh, Ambikapur, Korba and Dhamtari are few places in Chhattisgarh."},
                {"Q19: What is the capital of Gujarat?", "Ahmedabad", "Surat", "Gandhinagar", "Porbandar", "This state has the longest coastline in India. Ahmedabad, Surat, Vadodara, Rajkot, Porbandar, Dwarka, Ankleshwar and Jamnagar are few places in Gujarat."},
                {"Q20: What is the capital of Arunachal Pradesh?", "Naharlagun", "Bomdila", "Tawang", "Itanagar", "The first state in India where the sun rises. Tawang, Naharlagun, Tezu, Bomdila, Ziro and Khonsa  are few places in Arunachal Pradesh."},
                {"Q21: What is the capital of Tripura?", "Agartala", "Belonia", "Dharmanagar", "Bishalgarh", "The only other state where Bengali is majorly spoken. Belonia, Dharmanagar, Bishalgarh and Kailashahar are few places in Tripura."},
                {"Q22: What is the capital of Jharkhand?", "Ranchi", "Dhanbad", "Jamshedpur", "Bokaro", "Dhanbad, Jamshedpur, Bokaro, Hazaribagh, Deogarh, Jharia, Ghatshila and Jhumri Telaiya are few places in Jharkhand."},
                {"Q23: What is the capital of Manipur?", "Tamenglong", "Kakching", "Ukhrul", "Imphal", "Kakching, Ukhrul, Tamenglong, Moirang and Thoubal are few places in Manipur."},
                {"Q24: What is the capital of Meghalaya?", "Williamnagar", "Jowai", "Cherrapunji", "Shillong", "Mawsynram, a village in Meghalaya, receives the highest rainfall in the world. Cherrapunji, Tura, Jowai, Nongpoh, Dawki and Williamnagar are few places in Meghalaya."},
                {"Q25: What is the capital of Uttarakhand?", "Haridwar", "Dehradun", "Nainital", "Mussoorie", "Haridwar, Nainital, Mussoorie, Rishikesh, Roorkee, Kedarnath, Badrinath, Sitarganj, Devprayag and Bhimtal are few places in Uttarakhand."},
                {"Q26: What is the capital of Mizoram?", "Kolasib", "Lunglei", "Champhai", "Aizawl", "Champhai, Kolasib, Lunglei, Mamit and Saiha are few places in Mizoram."},
                {"Q27: What is the capital of Himachal Pradesh?", "Dharamshala", "Manali", "Shimla", "Dalhousie", "Dharamshala, Manali, Dalhousie, Chamba, Bilaspur, Theog, Kasol and Baijnath are few places in Himachal Pradesh."},
                {"Q28: What is the capital of Nagaland?", "Wokha", "Mokochung", "Kohima", "Dimapur", "Dimapur, Mokokchung, Wokha, Tuensang, Dzuleke, Khonoma and Mon are few places in Nagaland."},
                {"Q29: Which state is not a part of the Seven Sisters?", "Assam", "Sikkim", "Meghalaya", "Nagaland", "The North-Western states are collectively known as the Seven Sisters. The states are: Assam, Meghalaya, Arunachal Pradesh, Nagaland, Manipur, Mizoram and Tripura"},
                {"Q30: Which country shares a border with India?", "Afghanistan", "Vietnam", "Iran", "Mongolia", "India shares it's border with multiple countries. It shares land borders with Afghanistan, Pakistan, Nepal, Bhutan, China, Bangladesh, Myanmar; and water boders with Sri Lanka, Maldives, Thailand and Indonesia"}
        };
        question.setText(info[count][0]);
        optionOne.setText(info[count][1]);
        optionTwo.setText(info[count][2]);
        optionThree.setText(info[count][3]);
        optionFour.setText(info[count][4]);
        infoText.setText(info[count][5]);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        startButton = findViewById(R.id.startButton);
        viewMapButton = findViewById(R.id.viewMapButton);
        map = findViewById(R.id.map);
        backButton = findViewById(R.id.backButton);
        score = findViewById(R.id.score);
        question = findViewById(R.id.question);
        gridLayout = findViewById(R.id.gridLayout);
        optionOne = findViewById(R.id.optionOne);
        optionTwo = findViewById(R.id.optionTwo);
        optionThree = findViewById(R.id.optionThree);
        optionFour = findViewById(R.id.optionFour);
        infoText = findViewById(R.id.infoText);
        nextButton = findViewById(R.id.nextButton);
        mainMenuButton = findViewById(R.id.mainMenuButton);

    }
}
