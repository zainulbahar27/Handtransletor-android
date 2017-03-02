package com.example.zhaycefung.handtransletor;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.UUID;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;
    MediaPlayer starts, stops,wrongs;
    Button bicara, terjemah;
    TextView txtString,tekstimer,teksdata;
    Handler bluetoothIn;
//    public static double[][] am = {{476.2,535.1,459.5,447.5,592.2,-64.101,65.02,-22.92},{8.521867297,18.35120341,5.233439489,2.173067468,11.79265308,73.2258818,5.907343829,4.93927795}};
//    public static double[][] bm = {{524.6,409,417.2,417.9,409.3,-33.146,75.051,-13.55},{17.90840895,5.811865258,2.347575582,0.567646212,5.831904587,94.85701183,6.734545188,6.09172663}};
//    public static double[][] cm = {{469.2,413.5,423.6,423.8,445.6,-8.805,57.955,-28.829},{6.596295257,3.865804502,3.204163958,1.619327707,15.94574133,116.024668,6.520465645,5.642293564}};
//    public static double[][] dm = {{519.6,498.5,449.8,416.1,545.2,-38.648,63.139,-22.95},{16.41273219,34.98332936,3.224903099,0.737864787,21.73987632,118.2375102,2.632828855,2.360423691}};
//    public static double[][] em = {{531.7,553.7,458.3,446.6,585.6,1.636,81.008,-0.893},{5.207899982,14.5300455,1.567021236,1.0749677,9.924156835,111.9647245,6.470795589,8.600038824}};
//    public static double[][] fm = {{503,412.6,417.3,445.1,410.3,-7.016,75.363,1.101},{13.16561177,5.521674464,1.251665557,5.685263602,10.08904797,89.52646985,4.308263507,7.802842004}};
//    public static double[][] gm = {{466.4,554.1,459.3,418.8,585.8,-38.354,42.54,-27.118},{6.552353267,6.436872947,1.82878223,0.788810638,9.028350409,72.03611119,4.29700671,8.201571394}};
//    public static double[][] hm = {{512.4,512.5,417.1,416.7,540.4,-11.993,-1.606,-75.082},{3.306559138,17.33493582,0.875595036,0.674948558,6.518350166,6.263765374,5.229296107,2.539334121}};
//    public static double[][] im = {{517.2,424.8,459.6,444.6,540.4,78.554,79.301,-7.859},{14.71054044,6.390965846,6.736302976,3.83550663,23.79635826,8.64909141,4.390230189,7.223331718}};
//    public static double[][] jm = {{503.1,418.2,457.2,444,537.3,-106.67,60.894,7.656},{18.699079,3.119829055,5.138093031,2.357022604,16.09036979,7.552334444,8.128170766,8.238713762}};
//    public static double[][] km = {{482.6,543.1,418,416.7,554.1,81.924,81.257,-0.776},{2.796823595,15.45926547,0.816496581,0.674948558,10.12642308,3.801880237,3.322549389,1.278438283}};
//    public static double[][] lm = {{451.2,515.9,464.1,417.2,586.8,99.045,64.296,-7.932},{6.460134158,27.79868102,2.514402955,1.229272594,9.5312352,17.74982895,6.182563654,5.689561202}};
//    public static double[][] mm = {{533.7,518,445,442.1,535.6,96.197,71.338,15.321},{31.90976862,35.45889639,5.436502143,4.067486256,19.05080926,5.630208305,3.68194031,3.841803541}};
//    public static double[][] nm = {{533.5,556.9,449.3,443,552.2,101.014,75.74,13.659},{27.39931062,12.01341842,2.584139659,1.943650632,17.51063169,1.962199446,4.150579611,3.822109511}};
//    public static double[][] om = {{475.4,439.8,442.7,438.9,486.4,-44.304,21.356,-26.024},{7.848566748,13.33999833,3.164033993,2.558211181,14.22204861,5.333556662,13.47608516,3.479397138}};
//    public static double[][] pm = {{466.5,546.6,419.7,416.5,527.5,115.55,-58.857,-17.531},{10.88577053,14.92350867,3.093002856,0.527046277,17.61470345,5.834302777,5.456502848,5.012070874}};
//    public static double[][] qm = {{443.1,560.3,463,417.7,585.5,142.743,-45.864,-24.51},{1.91195072,7.761013679,1.825741858,0.674948558,2.368778401,3.149247,3.802324435,2.667137458}};
//    public static double[][] rm = {{497.5,513,419.7,422.9,592.2,86.738,77.952,1.968},{8.618455649,22.42022896,1.159501809,11.68522334,41.89616795,2.303629021,6.100048816,3.208560771}};
//    public static double[][] sm = {{531.9,543.8,465.6,456.1,583.5,89.103,80.11,1.759},{3.034981237,8.916900308,1.776388346,5.466056877,6.240548409,3.954440682,3.211981043,3.666940747}};
//    public static double[][] tm = {{473.2,545,458.8,428.8,580.6,76.938,74.728,-9.555},{9.738811244,9.988882709,1.751190072,3.084008935,5.796550698,5.096449309,2.422922019,3.736523191}};
//    public static double[][] um = {{494.4,524.7,418.1,419.3,564.4,84.47,81.532,-4.92},{5.295700562,26.75007788,0.316227766,0.483045892,21.81334963,1.772681584,2.000565476,1.418872792}};
//    public static double[][] vm = {{498.4,475.5,417.9,418.6,590,77.826,77.545,-11.744},{3.470510689,38.87658536,0.316227766,0.516397779,23.31427793,3.427594557,3.311707348,3.267446166}};
//    public static double[][] wm = {{505.5,552.4,417.7,418.7,411.2,80.175,76.192,-9.323},{3.472111109,20.48956374,0.483045892,0.674948558,2.1499354,6.328872552,6.469249999,5.930572485}};
//    public static double[][] xm = {{538.1,544.8,461.6,435.7,585,44.365,59.148,-29.493},{18.35725712,15.09083607,3.062315754,4.164666186,12.40071683,19.27909994,6.879432793,6.074087128}};
//    public static double[][] ym = {{464.7,428.1,452.7,440.8,532.2,73.026,71.525,-16.965},{12.73708496,33.79168208,3.433495142,4.709328803,17.85621585,9.801581732,7.003688314,8.795491585}};
//    public static double[][] zm = {{494.2,520.5,460.5,417.4,567.6,14.759,13.391,-61.028},{9.795690663,14.37010786,2.068278941,0.516397779,6.736302976,5.677181323,3.405004324,9.610910236}};
public static double[][] am ={{460.5,	414.1,	420.5,	420.3,	424.6,	72.958,	1.993,	477,	538,	460.7,	452.6,	586.6,	-62.565,	-10.413},{	3.689323937,	1.523883927,	0.707106781,	1.494434118,	6.484168755,	7.109086205,	3.576795742,	4,				24.62158042,	3.198958164,	2.503331114,	14.05702671,	6.938629788,	2.901559159}};
public static double[][] bm ={{464.1,	410.4,	418.2,	418,	417.2,	77.398,	4.923,	524.6,	403.3,	417.6,	417.2,	408.2,	73.576,		12.08},{	10.74399057,	4.599516883,	1.135292424,	1.154700538,	15.94295386,	4.414010019,	2.864957048,	4.427188724,	2.406010991,	0.699205899,	0.918936583,	1.751190072,	2.120189719,	0.917375484}};
public static double[][] cm ={{464.8,	414,	419.4,	418.3,	417.6,	74.341,	8.543,	452,	414.2,	424.5,	428.7,	442.4,	-5.637,		-3.112},{	12.17282949,	1.154700538,	0.699205899,	0.674948558,	3.098386677,	3.236584105,	2.732605797,	3.80058475,		2.740640639,	2.718251072,	2.750757471,	11.60651158,	4.834399997,	3.206620928}};
public static double[][] dm ={{466.4,	424.2,	422.8,	418.5,	439.3,	70.925,	10.722,	531.9,	530.7,	475.3,	421.6,	599.6,	58.14,		8.032},{	2.875181154,	3.39280284,		0.918936583,	0.971825316,	3.683295626,	2.112456443,	2.577202618,	8.723531395,	16.7666998,		1.636391694,	1.0749677,		5.891613625,	1.981346344,	2.171015124}};
public static double[][] em ={{470.9,	416.2,	418.3,	419.9,	415.3,	60.241,	8.374,	488.8,	414.1,	418.3,	445.8,	415.2,	-14.842,	0.847},{	4.653553003,	1.932183566,	1.059349905,	0.567646212,	2.540778533,	5.526864592,	2.180495357,	9.162726426,	2.766867463,	0.823272602,	2.394437999,	2.043961296,	6.180911116,	2.674729685}};
public static double[][] fm ={{489.2,	422.3,	418.3,	420.7,	427.2,	76.09,	3.2,	525.5,	419.6,	418.7,	459.5,	432.3,	-34.497,	-4.141},{	7.728734265,	3.128720008,	0.674948558,	1.33749351,		1.932183566,	2.159006973,	3.998591419,	6.753599863,	3.134042473,	0.948683298,	1.715938357,	1.702938637,	8.444982797,	3.973499577}};
public static double[][] gm ={{472.3,	430,	420.8,	419.2,	443.7,	71.629,	12.044,	532,	530.5,	420.8,	419.3,	589.3,	18.679,		57.232},{	6.992853495,	4.472135955,	1.229272594,	1.229272594,	6.447221624,	4.436250794,	3.179906358,	11.4406682,		23.36307628,	1.316561177,	0.674948558,	10.6879995,		1.385090851,	7.414915599}};
public static double[][] hm ={{472.3,	430,	420.8,	419.2,	443.7,	71.629,	12.044,	532,	530.5,	420.8,	419.3,	589.3,	18.679,		57.232},{		6.992853495,	4.472135955,	1.229272594,	1.229272594,	6.447221624,	4.436250794,	3.179906358,	11.4406682,		23.36307628,	1.316561177,	0.674948558,	10.6879995,		1.385090851,	7.414915599	}};
public static double[][] im ={{471.7,	419,	419.4,	418.9,	414.7,	70.568,	7.36,	484.7,	432.9,	449.8,	445.6,	536.3,	-52.978,	-12.481},{	5.417051268,	4.371625683,	0.699205899,	0.316227766,	1.888562063,	3.45345817,		2.537719886,	13.39195447,	6.723920814,	2.250925735,	2.170509413,	14.98184086,	9.786598319,	3.070321916}};
public static double[][] jm ={{490.7,	435,	444,	440.7,	515.3,	-43.987,-7.052,	490.2,	433.8,	439.1,	439,	498.3,	16.44,		52.528},{	7.572611468,	2.905932629,	5.374838499,	3.831158804,	19.39673512,	14.13096053,	8.499048051,	10.62282658,	3.425395354,	3.928528138,	2.867441756,	13.95269787,	4.720030603,	3.033687891}};
public static double[][] km ={{466.9,	413,	418,	417.7,	415.3,	68.41,	7.492,	466.4,	511.5,	418,	418.6,	546.6,	54.793,		-3.492},{	5.300943312,	2.905932629,	0.666666667,	0.823272602,	5.034326613,	4.193698977,	4.782483781,	2.716206505,	20.2991516,		0.816496581,	0.699205899,	20.28792744,	2.938983384,	1.324384973}};
public static double[][] lm ={{462,		411.9,	420.4,	417.2,	415.1,	73.932,	6.494,	429.3,	498,	464.1,	416.8,	594.5,	65.764,		8.674},{	9.809292646,	3.0713732,		0.699205899,	0.421637021,	1.100504935,	3.402593129,	2.412201392,	7.601900347,	7.958224258,	1.595131482,	0.421637021,	1.957890021,	3.269227568,	2.477818037}};
public static double[][] mm ={{466.5,	416.8,	420,	418.7,	414.3,	70.333,	9.246,	525.8,	523.4,	449.3,	446.9,	546.8,	-30.463,	-12.41},{	4.034572812,	2.043961296,	0.471404521,	0.483045892,	1.251665557,	2.860206092,	3.372671872,	17.06067603,	13.45114617,	1.494434118,	0.737864787,	6.08824003,		3.837829392,	3.343384845}};
public static double[][] nm ={{464.4,	414.2,	419.8,	418.7,	413.4,	66.456,	11.847,	523.4,	545.8,	442.6,	443.1,	549.9,	-20.751,	-20.957},{	3.098386677,	3.938414797,	0.632455532,	0.823272602,	2.011080417,	2.429641949,	2.351141803,	13.29327315,	12.62977083,	2.633122354,	2.233582076,	6.674162453,	9.06186325,		6.763447592}};
public static double[][] om ={{474,		418.7,	419.6,	418.7,	413.3,	65.672,	13.131,	492,	433,	441.8,	439.9,	507.8,	-34.516,	-4.955},{	7.483314774,	2.213594362,	0.699205899,	0.823272602,	2.213594362,	4.769532472,	4.561124252,	5.597618541,	16.70661878,	3.293090409,	2.424412873,	10.08629433,	4.863618223,	5.203027431}};
public static double[][] pm ={{471.8,	418.1,	418.5,	417.4,	412.8,	69.963,	6.469,	473.5,	542.7,	426.5,	417.6,	556.1,	-49.715,	30.733},{	3.084008935,	2.024845673,	0.527046277,	0.516397779,	2.097617696,	2.534254438,	1.738591064,	5.212165257,	13.40024875,	6.114645443,	0.699205899,	12.53838551,	3.600917321,	2.790663203}};
public static double[][] qm ={{475.9,	414.8,	419.6,	417.3,	411.9,	66.726,	12.426,	451.9,	532.4,	460.1,	419.4,	595.4,	-68.526,	16.157},{	3.725288952,	3.39280284,		0.699205899,	1.059349905,	0.994428926,	2.424702502,	2.161888064,	1.449137675,	17.72129917,	3.446415207,	0.699205899,	7.351492668,	5.479124423,	4.611495419}};
public static double[][] rm ={{473.2,	415.2,	416.7,	416.7,	410.6,	69.343,	6.855,	496.8,	519.6,	416.4,	417.4,	584.9,	54.307,		10.849},{	3.489667288,	3.765338999,	0.674948558,	0.823272602,	1.429840706,	3.383660247,	3.366865506,	2.97396107,		33.99738552,	1.0749677,		0.843274043,	46.2419963,		2.930665643,	1.862080378}};
public static double[][] sm ={{477.1,	410.7,	419.8,	417.9,	409.5,	64.585,	8.813,	503.8,	544.3,	468,	451.8,	603.5,	-64.015,	-23.069},{	3.142893218,	2.983286778,	1.229272594,	1.197219,		1.269295518,	2.568013716,	2.072293684,	5.827139569,	12.73708496,	2.160246899,	2.201009869,	46.17418711,	5.156256717,	4.737574274}};
public static double[][] tm ={{472.9,	430.1,	422.5,	419.6,	439.1,	66.653,	8.987,	516,	550.5,	462.8,	451.2,	593.3,	-18.443,	23.275},{7.32499526,		1.663329993,	0.527046277,	3.627058802,	4.840798832,	2.287832793,	1.717614948,	6.480740698,	7.074995092,	1.619327707,	4.756282395,	10.77084542,	2.773141219,	8.901644355}};
public static double[][] um ={{477.9,	426.5,	419.4,	418.4,	440.2,	72.49,	10.818,	514.6,	551.5,	420.1,	419.5,	624.7,	66.738,		11.403},{4.88648931,		3.719318934,	1.0749677,		1.0749677,		3.359894178,	2.659791136,	1.683546521,	7.183313998,	15.55099139,	0.316227766,	0.527046277,	10.38214279,	1.345913981,	2.157437008}};
public static double[][] vm ={{468.4,	425.4,	419,	418.2,	436.3,	71.517,	9.416,	505.7,	529.7,	419.1,	418.5,	608.6,	71.283,		1.212},{4.168666187,		3.306559138,	0.471404521,	1.135292424,	3.400980251,	2.662505295,	2.756685611,	6.583649781,	20.69916799,	0.994428926,	0.527046277,	12.2854928,		2.474384547,	2.293899155}};
public static double[][] wm ={{472.7,	414.3,	415.9,	417.7,	408.2,	70.271,	7.726,	510.7,	580.3,	416.5,	417.1,	410.9,	71.997,		-5.381},{6.532823109,		3.400980251,	1.791957341,	1.418136492,	1.619327707,	2.914722971,	3.512606503,	2.002775851,	16.65366159,	0.527046277,	2.024845673,	1.370320319,	2.447565911,	3.296029429}};
public static double[][] xm ={{458.7,	424,	423,	419.3,	442.3,	67.252,	11.553,	519,	532.7,	465.9,	444.3,	595.4,	-2.346,		19.38},{2.110818693,		4.136557882,	0.666666667,	1.418136492,	2.311805451,	2.51045724,		1.406303666,	14.15784039,	12.85863307,	1.197219,		1.82878223,		5.274677452,	3.977199461,	2.315148183}};
public static double[][] ym ={{477.1,	410,	418.2,	419.1,	409.2,	69.815,	10.004,	434.8,	429.8,	453.1,	448.5,	539.9,	-55.892,	-16.581},{5.02106673,		2.108185107,	0.632455532,	1.100504935,	1.229272594,	2.360462525,	1.628750032,	8.189424074,	1.932183566,	1.663329993,	2.718251072,	14.17705501,	5.787916148,	5.338125868}};
public static double[][] zm ={{477.1,	542.4,	467.6,	417.9,	597.7,	64.796,	9.194,	463,	530.1,	465.2,	417.9,	593.7,	-21.773,	19.66},{8.184674025,		13.15885844,	2.412928143,	0.567646212,	8.152027696,	5.482852461,	1.36076939,		3.231786572,	10.23555893,	1.87379591,		0.316227766,	4.667856991,	5.953895177,	9.085630902}};
    public  static  double[][] gausian= new double[26][14] ;
    public  static  double[] hasil = new double[26] ;
    public  static  double[] sensorin = new double[14] ;
    public static  String baca;
    double peluang = 0.038461538;
    char huruf = 'a';
    int index=0;
    int gauske=0;
    int k=0;
    boolean flag = true;
    boolean flagtharead = true;
    boolean flagtranslete = false;
    final int handlerState = 0;                        //used to identify handler message
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private StringBuilder recDataString = new StringBuilder();
    private long hasiltimer,hasiltimer2;
    private ConnectedThread mConnectedThread;

    // SPP UUID service - this should work for most devices
    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // String for MAC address
    private static String address;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        starts = MediaPlayer.create(this, R.raw.start);
        stops = MediaPlayer.create(this, R.raw.stop);
        wrongs = MediaPlayer.create(this, R.raw.wrong);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        //Link the buttons and textViews to respective views
        terjemah = (Button) findViewById(R.id.terjemahkan);
        bicara = (Button) findViewById(R.id.bicarakan);
        txtString = (TextView) findViewById(R.id.tampilan);
        tekstimer = (TextView) findViewById(R.id.timer);
        teksdata = (TextView) findViewById(R.id.data);
        bluetoothIn = new Handler() {
            public void handleMessage(android.os.Message msg) {
                if (msg.what == handlerState) {                                     //if message is what we want
                    String readMessage = (String) msg.obj;                                                                // msg.arg1 = bytes from connect thread
                    recDataString.append(readMessage);                                      //keep appending to string until ~
                    int endOfLineIndex = recDataString.indexOf("~");                    // determine the end-of-line
                    if (endOfLineIndex > 0) {                                           // make sure there data before ~
                        String dataInPrint = recDataString.substring(0, endOfLineIndex);    // extract string
                        //  txtString.setText("Data Received = " + dataInPrint);
                        int dataLength = dataInPrint.length();                          //get length of data received
//                        txtStringLength.setText("String Length = " + String.valueOf(dataLength));
                        // recDataString.
                        if (dataInPrint.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                        {
                            int j = 1;
//                            int k=0;
                            for (int i = 0; i < dataLength; i++) {
                                if (dataInPrint.charAt(i) == '~') {
                                    break;
                                }
                                if (dataInPrint.charAt(i) == '+') {
                                    baca = dataInPrint.substring(j, i);
                                    //  sensorView0.setText(" input = " + baca + "-");
                                    sensorin[k] = Double.valueOf(baca);
                                    k++;
                                    j = i + 1;
                                }
                            }
                            if (flagtranslete) {
                                for(int i=0;i<sensorin.length;i++)
                                {
                                    teksdata.setText(teksdata.getText()+String.valueOf(sensorin[i])+"+");
                                }
                                Toast.makeText(getBaseContext(), "Selesai", Toast.LENGTH_SHORT).show();
                                terjemah.setText("Terjemahkan");
                                //sensorin = null;
                                k=0;
                                stops.start();
                                flagtranslete=false;
                                hasiltimer2=System.currentTimeMillis();
                                txtString.setText(txtString.getText() + String.valueOf(naivebayes()));
                                tekstimer.setText("waktu komputasi : "+String.valueOf(System.currentTimeMillis()-hasiltimer)+"#"+
                                        String.valueOf(System.currentTimeMillis()-hasiltimer2));
                            } else {
                                teksdata.setText("");
                                hasiltimer = System.currentTimeMillis();
                                flagtranslete=true;
                                Toast.makeText(getBaseContext(), "Geasture di mulai", Toast.LENGTH_SHORT).show();
                                terjemah.setText("Berhenti");
                                starts.start();
                            }
                            mConnectedThread.write("2");
                        } else {
                            mConnectedThread.write("3");
                        }
                        flagtharead = true;
                        terjemah.setActivated(true);
                        recDataString.delete(0, recDataString.length());                    //clear all string data
                        // strIncom =" ";
                        dataInPrint = "";
                    }
                }
            }
        };

        btAdapter = BluetoothAdapter.getDefaultAdapter();       // get Bluetooth adapter
        checkBTState();

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(new Locale("id","ID"));
                }
            }
        });
        // Set up onClick listeners for buttons to send 1 or 0 to turn on/off LED
        bicara.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String toSpeak = txtString.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                flag = true;
            }
        });

        terjemah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(flagtharead) {
                    flagtharead = false;
                    terjemah.setActivated(false);
                    Toast.makeText(getBaseContext(), "Proses Menerjemahkan", Toast.LENGTH_SHORT).show();
                    if (flag) {
                        txtString.setText("");
                        tekstimer.setText("");
                        flag = false;
                    }
                    gauske = 0;
                    huruf = 'a';
                    mConnectedThread.write("1");    // Send "1" via Bluetooth
                }
                else{
                    wrongs.seekTo(500);
                    wrongs.start();
                    Toast.makeText(getBaseContext(), "Maaf,Ulangi beberapa detik lagi", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
        return  device.createRfcommSocketToServiceRecord(BTMODULEUUID);
        //creates secure outgoing connecetion with BT device using UUID
    }

    @Override
    public void onResume() {
        super.onResume();
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(new Locale("id","ID"));
                }
            }
        });

        //Get MAC address from DeviceListActivity via intent
        Intent intent = getIntent();

        //Get the MAC address from the DeviceListActivty via EXTRA
        address = intent.getStringExtra(DeviceListActivity.EXTRA_DEVICE_ADDRESS);

        //create device and set the MAC address
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try {
            btSocket = createBluetoothSocket(device);
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), "Socket creation failed", Toast.LENGTH_LONG).show();
        }
        // Establish the Bluetooth socket connection.
        try
        {
            btSocket.connect();
        } catch (IOException e) {
            try
            {
                btSocket.close();
            } catch (IOException e2)
            {
                //insert code to deal with this
            }
        }
        mConnectedThread = new ConnectedThread(btSocket);
        mConnectedThread.start();

        //I send a character when resuming.beginning transmission to check device is connected
        //If it is not an exception will be thrown in the write method and finish() will be called
        mConnectedThread.write("x");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        try
        {
            //Don't leave Bluetooth sockets open when leaving activity
            btSocket.close();
        } catch (IOException e2) {
            //insert code to deal with this
        }
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
    }

    //Checks that the Android device Bluetooth is available and prompts to be turned on if off
    private void checkBTState() {

        if(btAdapter==null) {
            Toast.makeText(getBaseContext(), "Device does not support bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if (btAdapter.isEnabled()) {
            } else {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }

    //create new class for connect thread
    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        //creation of the connect thread
        public ConnectedThread(BluetoothSocket socket) {
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            try {
                //Create I/O streams for connection
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[256];
            int bytes;

            // Keep looping to listen for received messages
            while (true) {
                try {
                    bytes = mmInStream.read(buffer);            //read bytes from input buffer
                    String readMessage = new String(buffer, 0, bytes);
                    // Send the obtained bytes to the UI Activity via handler
                    bluetoothIn.obtainMessage(handlerState, bytes, -1, readMessage).sendToTarget();
                } catch (IOException e) {
                    break;
                }
            }
        }
        //write method
        public void write(String input) {
            byte[] msgBuffer = input.getBytes();           //converts entered String into bytes
            try {
                mmOutStream.write(msgBuffer);                //write bytes over BT connection via outstream
            } catch (IOException e) {
                //if you cannot write, close the application
                Toast.makeText(getBaseContext(), "Connection Failure", Toast.LENGTH_LONG).show();
                finish();

            }
        }
    }
    private  char naivebayes()
    {
        perhitungan(sensorin,am);
        perhitungan(sensorin,bm);
        perhitungan(sensorin,cm);
        perhitungan(sensorin,dm);
        perhitungan(sensorin,em);
        perhitungan(sensorin,fm);
        perhitungan(sensorin,gm);
        perhitungan(sensorin,hm);
        perhitungan(sensorin,im);
        perhitungan(sensorin,jm);
        perhitungan(sensorin,km);
        perhitungan(sensorin,lm);
        perhitungan(sensorin,mm);
        perhitungan(sensorin,nm);
        perhitungan(sensorin,om);
        perhitungan(sensorin,pm);
        perhitungan(sensorin,qm);
        perhitungan(sensorin,rm);
        perhitungan(sensorin,sm);
        perhitungan(sensorin,tm);
        perhitungan(sensorin,um);
        perhitungan(sensorin,vm);
        perhitungan(sensorin,wm);
        perhitungan(sensorin,xm);
        perhitungan(sensorin,ym);
        perhitungan(sensorin,zm);
        perkalianpeluang();
        normalisasi();
        kesimpulan();
        return cetakhuruf();
    }
    private void perhitungan(double aq[],double base[][])
    {
        //=(1/SQRT(2*3.14*(stdev^2)))*(2.718282^(-(((input-mean)^2)/(2*(stdev^2)))))
        double d,e,f,g;
        for(int i=0;i<14;i++)
        {
            d = 2*3.14*(pow(base[1][i],2));
            e = (-((pow((aq[i]-base[0][i]),2))/(2*(pow(base[1][i],2)))));
            f = pow(2.718282,e);
            g = 1/sqrt(d);
            gausian[gauske][i] = f*g;
            //Serial.print(gausian[gauske][i],10);
            //Serial.print("\t");
        }

        gauske++;
        //Serial.println();

    }

    private void perkalianpeluang()
    {
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<14;j++)
            {
                if (j==0)
                {
                    hasil[i]=gausian[i][j];
                }
                else
                {
                    hasil[i]=hasil[i]*gausian[i][j];
                }
            }
            hasil[i]=hasil[i]*peluang;
            //  Serial.print(hasil[i]);
            // Serial.print("\t");
        }
        //Serial.println();
    }
    private double jumlah()
    {
        double hasilnya=0;
        for(int i = 0;i<hasil.length;i++)
        {
            hasilnya = hasilnya+hasil[i];
        }
        return hasilnya;
    }
    private void normalisasi()
    {
        for (int i=0;hasil.length>i;i++)
        {
            hasil[i]=hasil[i]/jumlah();
        }
    }
    private void kesimpulan()
    {
        double tertinggi=0;
        for(int i = 0;i<26;i++)
        {
            if(tertinggi <= hasil[i]||tertinggi == hasil[i])
            {
                tertinggi = hasil[i];
                index = i;
            }
        }
    }
    private char cetakhuruf()
    {
        for(int i=0;i<index;i++)
        {
            huruf++;
        }
        index = 0;
        //   Serial.print(huruf);
        return huruf;
    }


}