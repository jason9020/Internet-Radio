/*==============================================================================

name:       PjInternetRadio.java

purpose:    An Internet Radio using the PumaJ Framework.

history:    Sun Nov 27, 2011 08:46:23 (LBM) created.

notes:
This program was created by PumaJ
and is the confidential and proprietary product of PumaJ
Any unauthorized use, reproduction or transfer is strictly prohibited.

COPYRIGHT 2011 BY PumaJ
(Subject to limited distribution and restricted disclosure only).
All rights reserved.

==============================================================================*/
// package ----------------------------//

// imports ----------------------------//
import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import com.giavaneers.gui.elements.embedded.GvVLCMediaPlayer;
import com.pumaj.PjApplication;
import com.pumaj.PjOval;
import com.pumaj.PjRectangle;
import com.pumaj.PjShape;
import com.pumaj.PjTriangle;
import com.pumaj.PjUtils;
import java.awt.Color;
import java.awt.event.MouseEvent;
// PjInternetRadio ====================//
public class PjInternetRadio extends PjApplication
{
    // class constants --------------------//
    // (none)                              //
    // package instance variables ---------//
    // (none)                              //
    // pubic instance variables ----------//
    // (none)                              //
    // protected instance variables -------//
    protected GvIMediaPlayer mediaPlayer;  // media player 
    // private instance variables ---------//
    // (none)                              //
    /*------------------------------------------------------------------------------

    @name       PjInternetRadio - default constructor
     */
    /**
    Default constructor

    @return     An instance of PjInternetRadio if successful.

    @history    Sun Nov 27, 2011 08:46:23 (LBM) created.

    @notes
     */
    //------------------------------------------------------------------------------
    public PjInternetRadio()
    {
    }
    /*------------------------------------------------------------------------------

    @name       getMediaPlayer - get media player
     */
    /**
    Get media player instance.

    @return     media player instance.

    @history    Sun Nov 27, 2011 08:46:23 (LBM) created.

    @notes
     */
    //------------------------------------------------------------------------------
    public GvIMediaPlayer getMediaPlayer()
    {
        if (mediaPlayer == null)
        {
            mediaPlayer = new GvVLCMediaPlayer();
        }

        return(mediaPlayer);
    }
    /*------------------------------------------------------------------------------

    @name       background - back image
     */
    /**
    background image

    @return     void.

    @param      args  command line arguments

    @history    Sun Nov 27, 2011 08:46:23 (LBM) created.

    @notes
     */
    //------------------------------------------------------------------------------
    public void background(GvIMediaPlayer player, String[] mediaPaths) 
    {
        PjApplication myApp = new PjApplication();
        myApp.setLayout(null);
        myApp.setHeight(390);
        myApp.setWidth(602);
        PjShape BackgroundRect = new PjRectangle(); 
        BackgroundRect.setHeight(myApp.getHeight());
        BackgroundRect.setWidth(myApp.getWidth());
        BackgroundRect.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/Pulse.Template.jpg");
        boolean[] paused = new boolean[15];
        Click[] circles = new Click[15];
        Click[] circlesPaused = new Click[15];
        Click[] stationText = new Click[15];
        boolean shufflePaused = false;

        Click shuffle = new Click();
        Click shuffle2 = new Click();
        shuffle2.setVisible(false);
        shuffle.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/Shuffle.jpg");
        shuffle2.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/Shuffle1.jpg");
        shuffle.setHeight(40);
        shuffle2.setHeight(40);
        shuffle.setWidth(40);
        shuffle2.setWidth(40);
        shuffle.setLocation((602 - 270), 20);
        shuffle2.setLocation((602 - 270), 20);
        myApp.add(shuffle);
        myApp.add(shuffle2);

        Click mute = new Click();
        Click mute2 = new Click();
        boolean muteOn = false;
        mute.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/Mute.jpg");
        mute.setHeight(40);
        mute.setWidth(40);
        mute.setLocation((602 - 210), 20);
        myApp.add(mute);
        mute2.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/Mute2.jpg");
        mute2.setHeight(40);
        mute2.setWidth(40);
        mute2.setLocation((602 - 210), 20);
        myApp.add(mute2);
        mute2.setVisible(false);

        Click minus = new Click();
        minus.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/minus.jpg");
        minus.setHeight(40);
        minus.setWidth(40);
        minus.setLocation((myApp.getWidth() - 100), 20);
        myApp.add(minus);
        Click minus2 = new Click();
        minus2.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/minus2.jpg");
        minus2.setHeight(40);
        minus2.setWidth(40);
        minus2.setLocation((myApp.getWidth() - 100), 20);
        minus2.setVisible(false);
        myApp.add(minus2);
        Click minus3 = new Click();
        minus3.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/minus3.jpg");
        minus3.setHeight(40);
        minus3.setWidth(40);
        minus3.setLocation((myApp.getWidth() - 100), 20);
        minus3.setVisible(false);
        myApp.add(minus3);

        Click plus = new Click();
        plus.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/plus.jpg");
        plus.setHeight(40);
        plus.setWidth(40);
        plus.setLocation((myApp.getWidth() - 155), 20);
        myApp.add(plus);
        Click plus2 = new Click();
        plus2.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/plus2.jpg");
        plus2.setHeight(40);
        plus2.setWidth(40);
        plus2.setLocation((myApp.getWidth() - 155), 20);
        plus2.setVisible(false);
        myApp.add(plus2);
        Click plus3 = new Click();
        plus3.setImage("/Applications/InternetRadio.app/Contents/Resources/lib/plus3.jpg");
        plus3.setHeight(40);
        plus3.setWidth(40);
        plus3.setLocation((myApp.getWidth() - 155), 20);
        plus3.setVisible(false);
        myApp.add(plus3);

        player.setAudioVolume(0.7);

        for (int i = 0; i< 15; i++)
        { 
            circles[i] = new Click();
            circlesPaused[i] = new Click();
            stationText[i] = new Click();
            circles[i].setImage("/Applications/InternetRadio.app/Contents/Resources/lib/rsz_playbutton.jpg");
            circlesPaused[i].setImage("/Applications/InternetRadio.app/Contents/Resources/lib/PauseButton.jpg");
            circles[i].setHeight(40);
            circles[i].setWidth(40);
            circlesPaused[i].setWidth(40);
            circlesPaused[i].setHeight(40);
            circlesPaused[i].setVisible(false);
            stationText[i].setHeight(50);
            stationText[i].setWidth(100);
            stationText[i].setOpaque(false);
        }
        for (int i = 0; i < 5; i++)
        { 
            circles[i].setLocation( ( myApp.getWidth()/13 + i*115), (myApp.getHeight()*8/20 - 40) );
            circlesPaused[i].setLocation( ( myApp.getWidth()/13 + i*115), (myApp.getHeight()*8/20 - 40) );
            stationText[i].setLocation( ( myApp.getWidth()/13 + i*115 - 30), (myApp.getHeight()*8/20 - 40) - 45 );
            myApp.add(circles[i]);
            myApp.add(circlesPaused[i]);
            myApp.add(stationText[i]);
        }
        for (int i = 5; i < 10; i++)
        { 
            circles[i].setLocation( ( myApp.getWidth()/13 + (i - 5)*115), (myApp.getHeight()*13/20 - 40) );
            circlesPaused[i].setLocation( ( myApp.getWidth()/13 + (i - 5)*115), (myApp.getHeight()*13/20 - 40) );
            stationText[i].setLocation( ( myApp.getWidth()/13 + (i - 5)*115 - 30), (myApp.getHeight()*13/20 - 40) - 45 );
            myApp.add(circles[i]);
            myApp.add(circlesPaused[i]);
            myApp.add(stationText[i]);
        }
        for (int i = 10; i < 15; i++)
        { 
            circles[i].setLocation( ( myApp.getWidth()/13 + (i-10)*115), (myApp.getHeight()*18/20 - 40) );
            circlesPaused[i].setLocation( ( myApp.getWidth()/13 + (i-10)*115), (myApp.getHeight()*18/20 - 40) );
            stationText[i].setLocation( ( myApp.getWidth()/13 + (i-10)*115 - 30), (myApp.getHeight()*18/20 - 40) - 45 );
            myApp.add(circles[i]);
            myApp.add(circlesPaused[i]);
            myApp.add(stationText[i]);
        }
        stationText[0].setText("Top 40");
        stationText[1].setText("Classic Rock");
        stationText[2].setText("METAL");
        stationText[3].setText("Arabian");
        stationText[4].setText("Latin");
        stationText[5].setText("Hip-Hop");
        stationText[6].setText("Jazz");
        stationText[7].setText("Classical");
        stationText[8].setText("Bollywood");
        stationText[9].setText("Country");
        stationText[10].setText("60s");
        stationText[11].setText("70s");
        stationText[12].setText("80s");
        stationText[13].setText("90s");
        stationText[14].setText("00s");
        for (int i = 0; i < stationText.length; i++)
        {
            //stationText[i].setFont(Stencil);
            stationText[i].setFontSize(12);
            stationText[i].setFontColor(Color.white);
        }

        myApp.add(BackgroundRect);
        myApp.setVisible(true);
        while (true)
        {

            //mute is off and clicked
            if (mute.getClick() == true && muteOn == false)
            {
                player.setMute(true);
                mute.setVisible(false);
                mute2.setVisible(true);
                muteOn = true;
            }

            //mute is on and clicked 
            if (mute2.getClick() == true && muteOn == true)
            {
                player.setMute(false);
                mute.setVisible(true);
                mute2.setVisible(false);
                muteOn = false;
            }

            //increasing volume 
            if (plus.getClick() == true)
            {
                double volume = player.getAudioVolume(); 

                if (volume < 1.0)
                {
                    player.setAudioVolume(volume + 0.1);
                    plus.setVisible(false);
                    plus2.setVisible(true);
                }
                else
                {
                    player.setAudioVolume(volume);
                    plus.setVisible(false);
                    plus3.setVisible(true);
                }
                PjUtils.sleep(100); 
                plus.setVisible(true);
                plus2.setVisible(false);
                plus3.setVisible(false);
                plus.setClick(false);
            }

            //decreasing volume 
            if (minus.getClick() == true)
            {
                double volume = player.getAudioVolume();
                if (volume > 0.0)
                {
                    player.setAudioVolume(volume - 0.1);
                    minus.setVisible(false);
                    minus2.setVisible(true);
                }
                else
                {
                    player.setAudioVolume(volume);
                    minus.setVisible(false);
                    minus3.setVisible(true);
                }
                PjUtils.sleep(100); 
                minus.setVisible(true);
                minus2.setVisible(false);
                minus3.setVisible(false);
                minus.setClick(false);
            }

            //shuffle button is pressed
            int randStation = (int)(Math.random()*mediaPaths.length); 
            if (shuffle.getClick() == true && shufflePaused == false)
            { 
                resetButtons(player, circles, circlesPaused);
                player.setMute(false);
                shuffle.setVisible(false);
                shuffle2.setVisible(true);
                shufflePaused = true;
                //resets all the font to white
                for (int h = 0; h < circles.length; h++)
                {
                    stationText[h].setFontColor(Color.white);
                }        

                if (randStation % 3 != 0)
                {
                    int remainder = randStation % 3;
                    circlesPaused[(randStation - remainder)/3].setVisible(true);
                    circles[(randStation - remainder)/3].setVisible(false);
                    paused[(randStation - remainder)/3] = false;
                    stationText[(randStation - remainder)/3].setFontColor(Color.red);
                    for (int i = 0; i < circles.length; i++)
                    {
                        for (int j = 0; j < i; j++)
                        {
                            paused[j] = false;
                        }
                        for (int j = i + 1; j < paused.length; j++)
                        {
                            paused[j] = false;
                        }          
                    }
                    player.setMute(false);   
                }
                else
                {
                    circlesPaused[randStation/3].setVisible(true);
                    circles[randStation/3].setVisible(false);
                    paused[randStation/3] = false;
                    stationText[(randStation)/3].setFontColor(Color.red);
                    for (int i = 0; i < circles.length; i++)
                    {
                        for (int j = 0; j < i; j++)
                        {
                            paused[j] = false;
                        }
                        for (int j = i + 1; j < paused.length; j++)
                        {
                            paused[j] = false;
                        }          
                    }    
                    player.setMute(false);
                }    

                try
                {
                    player.setURI(mediaPaths[randStation]); // random station
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
            if (shuffle2.getClick() == true && shufflePaused == true)
            {
                if (randStation % 3 != 0)
                {
                    int remainder = randStation % 3;
                    paused[(randStation - remainder)/3] = true;
                    resetButtons(player, circles, circlesPaused);
                    shuffle.setVisible(true);
                    shuffle2.setVisible(false);
                    shufflePaused = false;
                    for (int h = 0; h < circles.length; h++)
                    {
                        stationText[h].setFontColor(Color.white);
                    }
                }
                else
                {
                    resetButtons(player, circles, circlesPaused);
                    paused[randStation/3] = true;
                    shuffle.setVisible(true);
                    shuffle2.setVisible(false);
                    shufflePaused = false;
                    for (int h = 0; h < circles.length; h++)
                    {
                        stationText[h].setFontColor(Color.white);
                    }
                }
            }
            if (circlesPaused[(randStation -(randStation % 3))/3].getClick() == true && shufflePaused == true)
            {
                if (randStation % 3 != 0)
                {
                    int remainder = randStation % 3;
                    paused[(randStation - remainder)/3] = true;
                    resetButtons(player, circles, circlesPaused);
                    shuffle.setVisible(true);
                    shuffle2.setVisible(false);
                    shufflePaused = false;
                    for (int h = 0; h < circles.length; h++)
                    {
                        stationText[h].setFontColor(Color.white);
                    }
                }
                else
                {
                    resetButtons(player, circles, circlesPaused);
                    paused[randStation/3] = true;
                    shuffle.setVisible(true);
                    shuffle2.setVisible(false);
                    shufflePaused = false;
                    for (int h = 0; h < circles.length; h++)
                    {
                        stationText[h].setFontColor(Color.white);
                    }
                }
            }

            for (int i = 0; i < circles.length; i++)
            {
                if (circles[i].getClick() == true && paused[i] == false)
                {
                    resetButtons(player, circles, circlesPaused);
                    for (int h = 0; h < circles.length; h++)
                    {
                        stationText[h].setFontColor(Color.white);
                    }
                    player.setMute(false);
                    paused[i] = true;

                    stationText[i].setFontColor(Color.red);
                    for (int j = 0; j < i; j++)
                    {
                        paused[j] = false;
                    }
                    for (int j = i + 1; j < paused.length; j++)
                    {
                        paused[j] = false;
                    }    

                    circles[i].setVisible(false);
                    circlesPaused[i].setVisible(true);
                    shuffle.setVisible(true);
                    shuffle2.setVisible(false);
                    shufflePaused = false;
                    if (circles[0].getClick())
                    {
                        int randTop40 = (int)(Math.random()*3);                        
                        try
                        {
                            player.setURI(mediaPaths[randTop40]); //Top40
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (circles[1].getClick())
                    {
                        int randRap = (int)(Math.random()*3 + 3);                        
                        try
                        {
                            player.setURI(mediaPaths[randRap]); //HIP HOP stations
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (circles[2].getClick())
                    {
                        int randSTATION3 = (int)(Math.random()*3 + 6);                       
                        try
                        {
                            player.setURI(mediaPaths[randSTATION3]); //Metal STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (circles[3].getClick())
                    {
                        int randSTATION4 = (int)(Math.random()*3 + 9);

                        try
                        {
                            player.setURI(mediaPaths[randSTATION4]); //STATION4 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }                    
                    }
                    if (circles[4].getClick())
                    {
                        int randSTATION5 = (int)(Math.random()*3 + 12);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION5]); //STATION5 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                    if (circles[5].getClick())
                    {
                        int randSTATION6 = (int)(Math.random()*3 + 15);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION6]); //STATION6 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (circles[6].getClick())
                    {
                        int randSTATION7 = (int)(Math.random()*3 + 18);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION7]); //STATION7 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (circles[7].getClick())
                    {
                        int randSTATION8 = (int)(Math.random()*3 + 21);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION8]); //STATION8 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                    if (circles[8].getClick())
                    {
                        int randSTATION9 = (int)(Math.random()*3 + 24);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION9]); //STATION9 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                    if (circles[9].getClick())
                    {
                        int randSTATION10 = (int)(Math.random()*3 + 27);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION10]); //STATION10 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                    if (circles[10].getClick())
                    {
                        int randSTATION11 = (int)(Math.random()*3 + 30);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION11]); //STATION11 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                    if (circles[11].getClick())
                    {
                        int randSTATION12 = (int)(Math.random()*3 + 33);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION12]); //STATION12 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                    if (circles[12].getClick())
                    {
                        int randSTATION13 = (int)(Math.random()*3 + 36);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION13]); //STATION13 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                    if (circles[13].getClick())
                    {
                        int randSTATION14 = (int)(Math.random()*3 + 39);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION14]); //STATION14 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                    if (circles[14].getClick())
                    {
                        int randSTATION15 = (int)(Math.random()*3 + 42);
                        try
                        {
                            player.setURI(mediaPaths[randSTATION15]); //STATION15 STATIONS
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                }
                if (circlesPaused[i].getClick() == true && paused[i] == true)
                {
                    resetButtons(player, circles, circlesPaused);
                    stationText[i].setFontColor(Color.white);
                    shuffle.setVisible(true);
                    shuffle2.setVisible(false);
                    shufflePaused = false;
                    paused[i] = false;
                }

            }
        }
    }
    /*------------------------------------------------------------------------------

    @name       main - project main routine
     */
    /**
    Project main routine

    @return     void.

    @param      args  command line arguments

    @history    Sun Nov 27, 2011 08:46:23 (LBM) created.

    @notes
     */
    //------------------------------------------------------------------------------
    public static void main(
    String   args[])
    {

        try
        {
            System.out.println(
                "Java VM running " + System.getProperty("java.version") 
                + ", " + System.getProperty("os.arch") +  ", " 
                + System.getProperty("sun.arch.data.model") + " bit");

            System.setProperty("jna.library.path","/Applications/InternetRadio.app/Contents/Resources/lib/vlclib/lib");

            PjInternetRadio myRadio = new PjInternetRadio();
            GvIMediaPlayer  player = myRadio.getMediaPlayer();
            String[]        mediaPaths =
                {
                    "http://8323.live.streamtheworld.com/KBEAFMAAC_SC", // top 40 1
                    "http://stream1.accuradio.com:8060",  // top 40 2
                    "http://stream1.accuradio.com:8060",  // top 40 3 (needs station)
                    "http://81.173.3.140:80", // Classic Rock 1
                    "http://webradio.antennevorarlberg.at:80/classicrock", // Classic Rock 2
                    "http://mp3channels.webradio.antenne.de/classic-rock-live", // Classic Rock 3
                    "http://50.7.77.114:8240", // METAL 1
                    "http://relay1.181.fm:8064",// METAL 2
                    "http://80.237.157.91:4400", // METAL 3
                    "http://icecast.omroep.nl/funx-arab-bb-mp3", // Arabian 1
                    "http://radio-dzair.net:8044/stream/1/", // Arabian 2
                    "http://streaming2.toutech.net:8000/jawharafm", // Arabian 3
                    "http://72.29.80.105:8083", // mexican (rap)
                    "http://laser.domint.net:8214", // mexican (merengue)
                    "http://pub8.sky.fm/sky_guitar", // mexican (flamenco)
                    "http://pub6.sky.fm/sky_classicrap_aacplus", // HIP HOP 
                    "http://stream1.accuradio.com:8024", // HIP HOP 2
                    "http://50.7.207.18:8000", // HIP HOP 3
                    "http://iochiice08.radioio.com:8000/1047", // Jazz 1
                    "http://174.36.1.92:7220", // Jazz 2
                    "http://174.37.86.106:8000", // Jazz 3
                    "http://7329.live.streamtheworld.com/KDFCFMAAC_SC", // Classical 1
                    "http://audio.kuer.org:8000/kuer3high", // classical 2 (SHITTY HUM CHANGE THIS)
                    "http://66.209.79.122:8002", // Classical 3
                    "http://198.154.106.101:8654", // Bollywood 1
                    "http://176.9.133.35:9999", // Bollywood 2
                    "http://46.28.49.164:7546/autodj", // Bollywood 3
                    "http://pub6.sky.fm/sky_country_aacplus", // Country 1
                    "http://out2.cmn.icy.abacast.com:80/kkqy-kkqyfm-64", // Country 2
                    "http://8353.live.streamtheworld.com/KLURFMAAC_SC", // Country 3
                    "http://sc-60s.1.fm:7030", //60s 1
                    "http://pub6.sky.fm/sky_beatles", // 60s 2
                    "http://iochiice08.radioio.com:8000/1033", // 60s 3
                    "http://rouge-70s.ice.infomaniak.ch:80/rouge-70s-64.aac", // 70s 1
                    "http://stream.hoerradar.de/saw70er-128", // 70s 3
                    "http://67.213.214.248:9866", // 70s 3
                    "http://pub6.sky.fm/sky_80srock_aacplus", // 80s 1
                    "http://pub6.sky.fm/sky_the80s_aacplus", // 80s 2
                    "http://listen.radionomy.com/absolom-80", // 80s 3
                    "http://cast.iplayradio.net:8069", // 90s 1
                    "http://173.192.32.199:7080", // 90s 2
                    "http://listen.radionomy.com/a-radio-90s-juice", // 90s 3
                    "http://iochiice08.radioio.com:8000/1048", // 00s 1
                    "http://50.117.115.210:80", // 00s 2
                    "http://pub5.sky.fm/sky_tophits", // 00s 3

                };
            // start the player                    
            myRadio.background(player, mediaPaths);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    /*
    ------------------------------------------------------------------------------

    @name       resetButtons - reset buttons
     */
    /**
    reset all the buttons

    @return     void.

    @param      args  array of Clicks

    @history    Sun Nov 27, 2011 08:46:23 (LBM) created.

    @notes
     */
    //------------------------------------------------------------------------------
    public void resetButtons(GvIMediaPlayer  player, Click[] a, Click[] b) 
    {
        for (int i = 0; i < a.length; i++)
        {
            a[i].setVisible(true);
            b[i].setVisible(false);
            player.setPlaying(false);
            player.setMute(true);

        }     
    }  
}//====================================// end PjInternetRadio -----------------//
