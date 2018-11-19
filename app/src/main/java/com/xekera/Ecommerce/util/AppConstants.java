package com.xekera.Ecommerce.util;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by shahrukh.malik on 02, April, 2018
 */
public class AppConstants {

    public static final String BASE_URL_UAT = "http://uat-hsk.tcscourier.com";
    public static final String BASE_URL_LIVE = "http://collect.tcscourier.com";

    public static int certificate_allow = 0;
    public static PublicKey _publicKey;
    public static PrivateKey _privateKey;
    public static X509Certificate x509Certificate;
    public static String certificateInBase64 = "";
    public static String encodedSign = "";

    //Transit time calculator
    public static final String TRANSIT_TIME_CALCULATOR_BASE_URL_UAT = "http://10.251.2.43:7801/api/v1/ttc/";

    //Transit time calculator station
    public static final String TRANSIT_TIME_CALCULATOR_STATION_BASE_URL_UAT = "http://10.251.2.43:7802/api/v1/ttc/";


    //Upload pickup travel log file
    //public static final String BASE_URL = "http://collect.tcscourier.com/";
    public static final String BASE_URL_API = BASE_URL_UAT + "/gpscoordinates/api/gps/";

    public static final String SIGNATURE_PHOTOS_DIRECTORY_NAME = "DSPH2 Signatures";
    public static final String DELIVERY_PHOTOS_DIRECTORY_NAME = "DELIVERY ITEMS";


    public static final String DATE_FORMAT_ONE = "yyyy-MM-dd HH:mm:ss z";
    public static final String DATE_FORMAT_TWO = "ddMMyy";
    public static final String DATE_FORMAT_THREE = "MMM dd";
    public static final String DATE_FORMAT_FOUR = "MMM dd, yyyy";
    public static final String DATE_FORMAT_FIVE = "dd/MM/yyyy";
    public static final String DATE_FORMAT_SIX = "MMMM   dd  yyyy";
    public static final String DATE_FORMAT_SEVEN = "yyyy-MM-dd";
    public static final String DATE_FORMAT_EIGHT = "MM/dd/yyyy";
    public static final String TIME_FORMAT_ONE = "hh:mm a";
    public static final String TIME_FORMAT_TWO = "hh:mm:ss";
    public static final String DATE_TIME_FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_TWO = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_TIME_FORMAT_THREE = "ddMMyy_HHmmss_";
    public static final String DATE_TIME_FORMAT_FOUR = "MM/dd/yyyy HH:mm:ss a";
    public static final String DATE_TIME_FORMAT_FIVE = "MM/dd/yyyy hh:mm:ss";
    public static final SimpleDateFormat TTCDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    public static final SimpleDateFormat TTCInputDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public static final int WIFI_PASSWORD_CONNECT_TIMEOUT = 16000;

    public static final String PREF_NAME = "xekera.ecommerce";
    public static final String DATABASE_NAME = "test";

    public static final String DP_USER_USERNAME = "admin";
    public static final String DP_USER_PASSWORD = "abc123";

    public static final String LOG_TAG_PICKUP = "BOSS_DK";

    public static int BATTERY_LEVEL = 25;
    public static final int BRIGHTNESS_LEVEL = 255;
    public static int CAMERA_BARCODE_LEVEL = 25;


    public static final String FROM_APP = "AndroidApp";
    public static final String FROM_API = "RESTAPI";

    public static final int JDBC_CONNECTION_TIMEOUT_DURATION_IN_SECONDS = 12;
    public static final int JDBC_QUERY_TIMEOUT_DURATION_IN_SECONDS = 2;
    public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    public static final String JDBC_CONNECTION_URL = "jdbc:oracle:thin:@10.0.152.13:1521:pdauat";
    public static final String U_PDA = "oms";
    public static final String P_PDA = "pda#123";
    public static final String IMEI_NUMBER_OF_1002_COURIER = "357640060049386";

    public static final String DIRECTORY_DELIVERY_TRAVEL_LOG = "DeliveryTravelLog";


    public static final String FLAG_RESET = "100";
    public static final String FLAG_SYNC = "200";

    public static final String NO_INTERNET_CONNECTION = "Please connect to internet";
    public static final String NO_RECORD_FOUND = "No record found";
    public static final String SHEET_ALREADY_FETCHED = "Sheet Already Fetched";
    public static final String NO_SHEET_AVAILABLE = "No sheet available";

    //Security Login
    public static String BASE_URL_FINAL = "http://uat-hsk.tcscourier.com/DSPhase2/WebAPI/";
    public static String LOGIN = BASE_URL_FINAL + "UserAuthentication";

    public static final String DELIVERY_DETAILS_CALLED_FROM_FRAGMENT_REATTEMPT = "reattempt";
    public static final String DELIVERY_DETAILS_CALLED_FROM_FRAGMENT_DASHBOARD = "dashboard";
    public static final String DELIVERY_DETAILS_CALLED_FROM_FRAGMENT_DELIVERY_SHEET = "delivery_sheet";

    public static final String DELIVERY_STATUS_DELIVERED = "DELIVERED";
    public static final String REATTEMPT_YES = "Yes";
    public static final String REATTEMPT_NO = "No";
    public static final String TRANSMITTED = "T";
    public static final String NOT_TRANSMITTED = "NT";

    // LIVE IDs
    /*public final static String FINJA_TILL_ID = "1997";
    public final static String CUSTOMER_ID_MERCHANT = "533005893";*/

    // UAT IDs
    public final static String FINJA_TILL_ID = "1090";
    public final static String CUSTOMER_ID_MERCHANT = "502139757";

    public static final String NAMES_LIST[] = {
            "AADIL", "AAKASH", "AALAY", "AAMER", "AAMIL", "AAMIR", "AAMNA", "AAQIB", "AASHER", "AASHI", "AATIF", "ABAD", "ABAID", "ABAIDULLAH", "ABAS", "ABASS", "ABBAS", "ABBASI", "ABDEEN", "ABDEL", "ABDI", "ABDUL", "ABDULLAH", "ABDUR", "ABEDIN", "ABEER", "ABID", "ABIDEEN", "ABRAR", "ABRO", "ABSAR", "ABU", "ABUBAKAR", "ABUBAKER", "ABUDL", "ABUL", "ABUZAR", "ADAM", "ADEEB", "ADEEL", "ADIL", "ADNAN", "ADREES", "AFAQ", "AFAQUE", "AFFAN", "AFGAN", "AFNAN", "AFONSO", "AFRAN", "AFRAZ", "AFRIDI", "AFSAR", "AFTAB", "AFZAAL", "AFZAL", "AGHA", "AGRO", "AHAD", "AHFAZ", "AHMAD", "AHMED", "AHMER", "AHSAN", "AHSANUL", "AHTASHAM", "AHTESHAM", "AHTISHAM", "AHTSHAM", "AIJAZ", "AISHA", "AIZAZ", "AJAB", "AJAY", "AJAZ", "AJMAIR", "AJMAL", "AJWAD", "AKASH", "AKBAR", "AKBER", "AKHLAQ", "AKHTAR", "AKHTER", "AKIF", "AKMAL", "AKRAAM", "AKRAM", "AL", "ALAM", "ALAMDAR", "ALAUDDIN", "ALBERT", "ALEEM", "ALFAN", "ALFRED", "ALI", "ALIA", "ALIAS", "ALLY", "ALMAS", "ALTAF", "ALTAMASH", "ALVI", "ALVIN", "ALYAS", "AMAD", "AMAISH", "AMAN", "AMANAT", "AMANOAIL", "AMANULLAH", "AMEEN", "AMEER", "AMER", "AMIN", "AMINULLAH", "AMIR", "AMJAD", "AMJED", "AMMAD", "AMMAR", "AMMARA", "AMNA", "AMRAIZ", "AMRIN", "AMSAL", "ANAM", "ANAND", "ANAS", "ANAYAT", "ANDAZ", "ANDLEEB", "ANEEB", "ANEEL", "ANEES", "ANIL", "ANIQ", "ANIS", "ANJUM", "ANS", "ANSAR", "ANSARI", "ANTHONY", "ANUM", "ANWAR", "ANWER", "AORUNG", "AOUN", "AQDAS", "AQEEL", "AQIB", "AQIF", "AQIL", "ARAIB", "ARAIN", "ARFA", "ARFAN", "ARHAM", "ARIF", "ARMAN", "ARSAL", "ARSALAN", "ARSHAD", "ARSHAN", "ARSLAN", "ASAD", "ASADI", "ASADULLAH", "ASAM", "ASEEM", "ASFANDYAR", "ASFAR", "ASGHAR", "ASGHER", "ASHAR", "ASHER", "ASHFAQ", "ASHFAQUE", "ASHIQ", "ASHIQUE", "ASHOKE", "ASHRAF", "ASIF", "ASIM", "ASJAD", "ASKARI", "ASLAM", "ASMA", "ASMI", "ASRAR", "ASSAD", "ASSI", "ATA", "ATEEQ", "ATHAR", "ATHER", "ATIF", "ATIK", "ATIQ", "ATIQUE", "ATIR", "ATTA", "ATTARI", "ATTA-UR-REHMAN", "ATTEEQ", "ATTIQ", "ATTIQUE", "ATTTIQ", "AUGUSTO", "AUN", "AURANGZAIB", "AURANGZEB", "AWAIS", "AWAIZ", "AWAN", "AWON", "AYAZ", "AYESHA", "AYOUB", "AYUB", "AYYAZ", "AZAD", "AZAIR", "AZAM", "AZEEM", "AZFAR", "AZHAR", "AZHER", "AZIM", "AZIZ", "AZIZULLAH", "AZKAR", "AZLAN", "AZMAT", "AZME", "AZRA", "AZZAM", "BABAR", "BABER", "BABOO", "BACHA", "BACHAYA", "BADAR", "BADDAR", "BADEEN", "BADER", "BADSHAH", "BAHADAR", "BAHADUR", "BAHAR", "BAHDUR", "BAHZAD", "BAIDAR", "BAIG", "BAJWA", "BAKAR", "BAKHAT", "BAKHSH", "BAKHT", "BAKHTAJ", "BAKHTIAR", "BAKSH", "BALADI", "BALAL", "BALOCH", "BALOUCH", "BANGASH", "BANO", "BAQAR", "BARAR", "BARAT", "BARI", "BARIZ", "BARKAT", "BAROHI", "BASEER", "BASHARAT", "BASHEER", "BASHIR", "BASIT", "BAZMI", "BEDI", "BEENA", "BEENISH", "BEHZAD", "BESTAN", "BHADUR", "BHAMBHRO", "BHATTI", "BHUTTO", "BIBI", "BILAL", "BILAWAL", "BILLA", "BIN", "BINA", "BINYAMIN", "BOOTA", "BOSCO", "BUGTI", "BUKHSH", "BUKSH", "BUNAIR", "BURHAN", "BURIRO", "BURT", "BUSHRA", "BUTT", "BUX", "CECIL", "CEDRIC", "CH", "CH.", "CHAN", "CHAND", "CHANDIO", "CHANGEZI", "CHANNA", "CHANNU", "CHARLES", "CHAUDHERY", "CHAUDHRY", "CHAWLA", "CHEEMA", "CHELVY", "CHIRAGH", "CHISHTI", "CHOHAN", "CHRISTOPHER", "CHUGHTAI", "CHUGHTTAEE", "CHUGTAI", "CHUHAN", "COL", "CRISTOPHER", "D", "DAD", "DADAN", "DANIAL", "DANIEL", "DANISH", "DANIYAL", "DANYAL", "DAR", "DARAZ", "DAS", "DASTAGER", "DASTAGIR", "DASTGEER", "DAUD", "DAVID", "DAWAOOD", "DAWAR", "DAWOOD", "DEAN", "DEMAS", "DEROOM", "DERWAISH", "DHOCHA", "DIANAT", "DILAWAR", "DILAWER", "DILBAR", "DILDAR", "DILFRAZ", "DILROZ", "DILSHAD", "DIN", "DINO", "DITTA", "DITTAH", "DOGAR", "DOJANA", "DOWLAT", "D'SOUZA", "DURRANI", "E", "EARNEST", "EDWIN", "EHSAN", "EHTISHAM", "EIBAD", "EIJAZ", "EJAZ", "ELAHI", "ELLAHI", "EMANUEL", "EMMANUEL", "ESHRAT", "F.", "FAHAD", "FAHEEM", "FAHEEMULLAH", "FAHIM", "FAISAL", "FAIZ", "FAIZA", "FAIZAN", "FAIZANUDDIN", "FAIZULLAH", "FAKAR", "FAKHAR", "FALAK", "FAQEER", "FAQIR", "FARAH", "FARAN", "FARAS", "FARAZ", "FAREED", "FAREEDUDDIN", "FARHAD", "FARHAJ", "FARHAN", "FARHAT", "FARID", "FARIHA", "FARJAD", "FARKHANDA", "FARMAN", "FAROOQ", "FAROOQI", "FAROOQUE", "FAROOQUI", "FARRUKH", "FARUKH", "FASEEH", "FASIEH", "FASIH", "FATAH", "FATANY", "FATIMA", "FAUZIA", "FAWAD", "FAYAZ", "FAYYAZ", "FAZAL", "FAZAL-E-RAZZAQ", "FAZALKARIM", "FAZEEL", "FAZIL", "FAZLI", "FEROZ", "FEROZE", "FIAZ", "FIDA", "FLOWER", "FOUZI", "FRANCIS", "FRASAT", "FRAZ", "FURQAN", "GABOOL", "GABRIEL", "GADANI", "GADDAFI", "GADDI", "GAVER", "GAY", "GEORGE", "GHAFAR", "GHAFFAR", "GHAFOOR", "GHALIB", "GHANI", "GHARIS", "GHAURI", "GHAYAS", "GHAYOUR", "GHAYUR", "GHAYYOOR", "GHAZALA", "GHAZALI", "GHAZANFAR", "GHAZANFARABIDI", "GHAZANFER", "GHAZI", "GHIAS", "GHORI", "GHOURI", "GHOUS", "GHOUSUDDIN", "GHUFRAN", "GHULAM", "GHULLAM", "GHUMAN", "GILANI", "GILBERT", "GILL", "GILLANI", "GODFREY", "GOHAR", "GOHEER", "GONDAL", "GOPAL", "GORAYA", "GOUHAR", "GOVEAS", "GOVINDAN", "GRIFFIN", "GUJJAR", "GUL", "GULA", "GULAB", "GULAM", "GULBAZ", "GULFAM", "GULFARAZ", "GULFRAZ", "GULHASSAN", "GULISTAN", "GULL", "GULRAIZ", "GULZAR", "H.", "HABIB", "HABIBULLAH", "HABIB-ULLAH", "HADAYAT", "HADER", "HADI", "HADIYAT", "HAFEEZ", "HAFEEZ-UR-REHMAN", "HAFIZ", "HAIDER", "HAIDRI", "HAIDRY", "HAJI", "HAKEEM", "HAKIM", "HAKRO", "HALA", "HALEEM", "HAMAYAUN", "HAMDANI", "HAMEED", "HAMESH", "HAMID", "HAMIDULLAH", "HAMMAD", "HAMMIAT", "HAMOOD", "HAMRAZ", "HAMZA", "HANEEF", "HANIF", "HANNAN", "HANZALA", "HAQ", "HAQDAD", "HAQUE", "HAREEM", "HARIS", "HARIZ", "HAROON", "HARRIS", "HARRISON", "HASAN", "HASEEB", "HASEEM", "HASHAM", "HASHIM", "HASHMAT", "HASHMI", "HASIL", "HASMI", "HASNAIN", "HASSAAN", "HASSAIN", "HASSAINE", "HASSAM", "HASSAN", "HASSNAIN", "HATIM", "HAYAT", "HAYDER", "HAZARO", "HAZRAT", "HEERA", "HIDAYAT", "HIDAYATULLAH", "HIFAZAT", "HILAL", "HIMAYAT", "HINA", "HIRAZ", "HISSAIN", "HOMAIR", "HUDA", "HUMA", "HUMAIR", "HUMAIRA", "HUMAYOON", "HUMAYUN", "HUMEIRA", "HUMZA", "HUSAIN", "HUSNAIN", "HUSSAIN", "HUSSAN", "HUSSNAIN", "HUZIFA", "HYDER", "HYE", "IBRAHEEM", "IBRAHIM", "IBRAR", "IDNAN", "IDREES", "IFRAZ", "IFTIAZ", "IFTIKHAR", "IHSAN", "IHSANULLAH", "IHTASHAM", "IHTISHM", "IHTRAM", "IHTSHAM", "IJAZ", "IJLAL", "IKHLAQ", "IKHLAS", "IKRAM", "IKRAM-UL-HAQ", "IKRAMULLAH", "ILAHI", "ILLAH", "ILTAF", "ILYAS", "IMAD", "IMAM", "IMDAD", "IMRAN", "IMRANUD", "IMTIAZ", "INAM", "INAMULLAH", "INAYAT", "INAYATULLAH", "INDER", "INDLEEB", "INTEZAR", "INTIZAR", "INZIMAM", "IQBAL", "IQLAK", "IQRAR", "IRAFAN", "IRAM", "IRFAN", "IRFANULLAH", "IRSHAD", "IRTAZA", "ISHAQ", "ISHAQUE", "ISHFAQ", "ISHFAQUE", "ISHRAQ", "ISHTIAQ", "ISHTIAQUE", "ISHTIHAR", "ISLAH", "ISLAM", "ISMAIL", "ISRAIL", "ISRAR", "ITRAT", "IZHAR", "IZHAR-UD-DIN", "IZHARUL", "IZZAT", "J.", "JAAN", "JABBAR", "JABEEN", "JABRAN", "JADOON", "JAFAR", "JAFERI", "JAFERY", "JAFFAR", "JAFFER", "JAFFERY", "JAFFRI", "JAFRANI", "JAFREE", "JAFRY", "JAGMOHAN", "JAH", "JAHAN", "JAHANGEER", "JAHANGIR", "JAHANZAIB", "JAHANZEB", "JALAL", "JALIL", "JALIS", "JALLANI", "JAM", "JAMAL", "JAMALI", "JAMEEL", "JAMES", "JAMIL", "JAMSHAD", "JAMSHAID", "JAMSHED", "JAMSHEED", "JAN", "JANA", "JANGRA", "JANI", "JANJUA", "JASEEM", "JASIM", "JASON", "JAT", "JATOI", "JAVAD", "JAVAID", "JAVED", "JAVEED", "JAVERIA", "JAVID", "JAVWED", "JAWAD", "JAWAID", "JAWED", "JAWWAD", "JAZIB", "JEELANI", "JEET", "JEHAN", "JEHANGIR", "JELANI", "JERALD", "JESEEM", "JHATIAL", "JHON", "JIBRAN", "JILANI", "JILLANI", "JINSAR", "JOHAR", "JOHN", "JOHNEY", "JOHNSON", "JOKHIO", "JOSE", "JOSEPH", "JOSHWA", "JOYO", "JUMA", "JUNAID", "KABEER", "KABIL", "KABIR", "KAFEEL", "KAHLIQ", "KAHN", "KAHSIF", "KALEEM", "KALIM", "KALSOOM", "KALWAR", "KAMAL", "KAMEER", "KAMIL", "KAMRAN", "KANWAL", "KANWAR", "KANYA", "KARAM", "KARAMAT", "KAREEM", "KARIM", "KARIMULLAH", "KASHAN", "KASHIF", "KAUSAR", "KAWISH", "KAYANI", "KAZIM", "KAZMI", "KESHODIA", "KH.", "KH.KHURSHID", "KHADAM", "KHADIM", "KHAILID", "KHAISTA", "KHAKAN", "KHALEEL", "KHALID", "KHALIL", "KHALIQ", "KHALIQUE", "KHAN", "KHANANI", "KHANWAIZE", "KHASKHELI", "KHATAB", "KHATTAK", "KHAWAJA", "KHAWAR", "KHAWER", "KHAYYAM", "KHELI", "KHITAB", "KHIZAR", "KHOKHAR", "KHOKHER", "KHOLA", "KHOSHLIM", "KHOSO", "KHUBAIB", "KHUHRO", "KHURAM", "KHURRAM", "KHURSHEED", "KHURSHID", "KHUSHAM", "KHUSHI", "KHUSHIK", "KHUSHNOOD", "KHWELID", "KHYBER", "KIANI", "KIFAYAT", "KIFAYATULLAH", "KINZA", "KIRAN", "KISHORE", "KIYANI", "KOKAB", "KOLACHI", "KOMAL", "KOUSER", "KRISTINE", "KUMAR", "KUNWAR", "KURVE", "L.", "LABHA", "LACHMAN", "LADHA", "LAEEQ", "LAGHARI", "LAIQ", "LAL", "LANGAH", "LASHARI", "LATEEF", "LATIF", "LATIFULLAH", "LAYBA", "LEGHARI", "LIAQAT", "LIAQUAT", "LIMA", "LINDSAY", "LODHI", "LT.", "LUBNA", "LUCAS", "LUKE", "LUQMAN", "M", "M.", "M.AMIR", "M.ATTA", "M.AWAIS", "M.KASHIF", "M.MAZHAR", "M.RAHEEL", "M.REHAN", "M.SAFWAN", "M.SARDARUDDIN", "M.SHAHBAN", "M.TAHIR", "M.TAIMOOR", "M.WASIQ", "M.YOUSUF", "MADAH", "MADASIR", "MADIHA", "MADNI", "MAGHNANI", "MAGSI", "MAHAD", "MAHAR", "MAHBOOB", "MAHDI", "MAHFOOZ", "MAHIR", "MAHMOOD", "MAHMUD", "MAHNOOR", "MAHRUKH", "MAHTAB", "MAIRAJ", "MAJ", "MAJEED", "MAJEEDULLAH", "MAJID", "MAJOR", "MALAH", "MALAK", "MALIK", "MALLAH", "MANAN", "MANAZAR", "MANGI", "MANNA", "MANNAN", "MANSAB", "MANSHA", "MANSHI", "MANSOOR", "MANZAR", "MANZOOR", "MAOZAY", "MAQBOOL", "MAQSOOD", "MARFANI", "MARGHOOB", "MARIAM", "MARIB", "MARINA", "MARIUM", "MARJAN", "MAROOF", "MARVYN", "MARYAM", "MASAB", "MASAUD", "MASEEH", "MASHHOOR", "MASHI", "MASHKOOR", "MASHOOD", "MASHOOQ", "MASIH", "MASKEEN", "MASOOD", "MASOOM", "MASROOR", "MAST", "MASUD", "MATEEN", "MATI", "MATLOOB", "MATTHEW", "MAZHAR", "MAZIN", "MEER", "MEEZAN", "MEHAR", "MEHARBAN", "MEHBOOB", "MEHDI", "MEHFOOZ", "MEHMOOD", "MEHR", "MEHRAN", "MEHREEN", "MEHROSH", "MEHROZE", "MEHTAB", "MEHWISH", "MEMON", "MERAJ", "MIAN", "MICHAEL", "MIN", "MINHAJ", "MINHAS", "MINHER", "MIR", "MIRAJ", "MIRBAHAR", "MIRZA", "MISBAH", "MISBAH-UD-DIN", "MISKEEN", "MISLAH", "MISRI", "MITHAL", "MITHOU", "MOAZAM", "MOAZZAM", "MOBEEN", "MOBIN", "MOEED", "MOEEZ", "MOFIQUE", "MOHAMMAD", "MOHAMMAED", "MOHAMMED", "MOHAN", "MOHD.IRFAN", "MOHI", "MOHIB", "MOHIUDDIN", "MOHIYUDDIN", "MOHSAN", "MOHSIN", "MOHTASHIM", "MOHTRAM", "MOHY", "MOHYYUDIN", "MOIN", "MOINI", "MOIN-UD-DIN", "MOIZ", "MOMIN", "MONIS", "MOORO", "MOOZAM", "MORO", "MOTASIM", "MOUAZZAM", "MOUZZAM", "MOZZAM", "MS.", "MUAHAMMAD", "MUAVIA", "MUBARAK", "MUBARIK", "MUBASHAR", "MUBASHER", "MUBASHIR", "MUBASSHIR", "MUBBSHER", "MUBEEN", "MUBIN", "MUDABBIR", "MUDASAR", "MUDASSAR", "MUDASSIR", "MUDDASAR", "MUDDASIR", "MUDDASSAR", "MUDDASSIR", "MUEEN", "MUGHAL", "MUHABBAT", "MUHAMAD", "MUHAMAMAD", "MUHAMAMD", "MUHAMMA", "MUHAMMAD", "MUHAMMD", "MUHAMMMAD", "MUHARRAM", "MUHI", "MUHMMAD", "MUIHAMMAD", "MUJADDAD", "MUJAHID", "MUJASSAM", "MUJEEB", "MUJEEBULLAH", "MUJTABA", "MUKARRAM", "MUKESH", "MUKESHA", "MUKHAFFAR", "MUKHDOOM", "MUKHTAR", "MUKHTIAR", "MUKKARAM", "MULA", "MULLAH", "MUMMTAZ", "MUMTAZ", "MUNAF", "MUNAM", "MUNAWAR", "MUNAZZA", "MUNEEB", "MUNEEM", "MUNEER", "MUNIEM", "MUNIR", "MUNSIF", "MUNTAZIR", "MUQADDAR", "MUQEEM", "MUQEET", "MURAD", "MUREED", "MURSALEEN", "MURSLEEN", "MURTAZA", "MUSAB", "MUSADDAF", "MUSADDIQ", "MUSARAT", "MUSARRAT", "MUSASSAR", "MUSAWAR", "MUSHAHID", "MUSHARAF", "MUSHTAQ", "MUSHTAQUE", "MUSSADIQ", "MUSTAFA", "MUSTAHSAN", "MUSTAJAB", "MUSTAMIR", "MUSTAQEEM", "MUSTEHSAN", "MUZAFFAR", "MUZAHIR", "MUZAKKIR", "MUZAMIL", "MUZAMMIL", "MUZFAR", "N0MAN", "NABEEL", "NABI", "NADEEM", "NADIA", "NADIR", "NAEEM", "NAEEMUDDIN", "NAEEM-UD-DIN", "NAEEMULLAH", "NAFEES", "NAHEED", "NAHEEM", "NAHID", "NAIK", "NAILA", "NAIMATULLAH", "NAIYER", "NAJAF", "NAJAFI", "NAJAM", "NAJEEB", "NAJEEM", "NAJMI", "NAJUM", "NAQASH", "NAQEEB", "NAQIB", "NAQVI", "NARAVI", "NARGIS", "NARIN", "NARMEEN", "NASAR", "NASARAT", "NASEEB", "NASEEBULLAH", "NASEEM", "NASEER", "NASIM", "NASIR", "NASREEN", "NASRULLAH", "NATHANIEL", "NAUKAR", "NAUMAN", "NAUSHAD", "NAVED", "NAVEED", "NAVEEL", "NAWAB", "NAWAID", "NAWAZ", "NAWED", "NAYAB", "NAYYAR", "NAYYER", "NAZ", "NAZAKAT", "NAZAR", "NAZEER", "NAZIA", "NAZIM", "NAZIMUDDIN", "NAZIR", "NAZISH", "NEEHAN", "NELSON", "NIAMAT", "NIAZ", "NIAZI", "NIDA", "NIGAH-E-HASNAIN", "NIHAL", "NIJAT", "NIMAN", "NISAR", "NISHAN", "NIZAMUDDIN", "NOBAHAR", "NOMAM", "NOMAN", "NOMANI", "NOOR", "NOORANI", "NOORULLAH", "NORANI", "NOREEN", "NORRIS", "NOSHABA", "NOSHEEN", "NOUMAN", "NUMAN", "NUSRAT", "NUSRATULLAH", "OBAID", "OMAIR", "OMAR", "OMER", "ORANG", "OSAMA", "OSKAR", "OVAIS", "OWAIS", "PALARI", "PANHOR", "PANHWAR", "PARACHA", "PARAKENDY", "PARDEEP", "PARVAIZ", "PARVEEN", "PARVEZ", "PARWAZ", "PASHA", "PATHAN", "PATRAS", "PAUL", "PERDEEP", "PERVAIZ", "PERVEZ", "PERVIAZ", "PERWAIZ", "PERWEZ", "PETER", "PHILIPS", "PHILLPOTO", "PIR", "PIRZADA", "PITRAS", "POLOUS", "PREETAM", "PREM", "PREMI", "QADEER", "QADIR", "QADRI", "QAISAR", "QAISER", "QALANDAR", "QALB", "QAMAR", "QAMBAR", "QAMBER", "QAMER", "QASEEM", "QASIM", "QASIR", "QAVI", "QAYOM", "QAYOOM", "QAYUM", "QAYYUM", "QAZAFI", "QAZI", "QAZZAFI", "QUDDOOS", "QUDOOS", "QUMMAR", "QUNDEEL", "QURASHI", "QURBAN", "QURESHI", "RAB", "RABAB", "RABB", "RABBANI", "RABBI", "RABEET", "RABI", "RABIA", "RABIYA", "RAEES", "RAFAQAT", "RAFAY", "RAFEA", "RAFFIQUE", "RAFI", "RAFIQ", "RAFIQUE", "RAFIULLAH", "RAHAT", "RAHEEL", "RAHEEM", "RAHIB", "RAHIL", "RAHIM", "RAHMAN", "RAHMAT", "RAIS", "RAJA", "RAJAB", "RAJESH", "RAJOO", "RAJPUT", "RAKHA", "RAKHIO", "RAM", "RAMCHAND", "RAMEEZ", "RAMELLA", "RAMESH", "RAMISH", "RAMIZ", "RAMZAN", "RANA", "RANA.MUHAMMAD", "RANI", "RANJHA", "RAO", "RASHED", "RASHEED", "RASHID", "RASIKH", "RASOOL", "RASUL", "RATYAL", "RAUF", "RAVI", "RAZA", "RAZI", "RAZZAQ", "REEMA", "REHAN", "REHMAN", "REHMAT", "REJA", "RIASAT", "RIAZ", "RISVAN", "RITA", "RIYASAT", "RIZVI", "RIZWAN", "RIZWANUDDIN", "RIZWANULLAH", "ROBEL", "ROBIN", "ROCKY", "ROHAIL", "ROHAN", "ROHEEL", "ROMAIL", "ROMAN", "RONALD", "ROOH", "ROSARIO", "ROSHAN", "ROUWAID", "ROY", "RUBI", "RUKHSAR", "RUSTAM", "S", "S.", "S.HASAN", "S.M.", "S.M.ISHTIAQ", "S.M.KAUSAR", "S.NADEEM", "S.SAMEER", "SAAD", "SAADAT", "SAADUL", "SABA", "SABEEL", "SABIH", "SABIR", "SABOOR", "SABRI", "SADAAM", "SADAF", "SADAM", "SADAQAT", "SADDAM", "SADDIQ", "SADDIQUE", "SADDIQUI", "SADEEQ", "SADI", "SADIA", "SADIQ", "SADULLAH", "SAEED", "SAFA", "SAFADR", "SAFDAR", "SAFDER", "SAFEER", "SAFI", "SAFIULLAH", "SAGAR", "SAGEER", "SAGER", "SAGHAR", "SAGHEER", "SAGHIR", "SAHAR", "SAHIB", "SAHID", "SAHITO", "SAHTO", "SAID", "SAIF", "SAIFAL", "SAIFUDDIN", "SAIFULLAH", "SAIM", "SAIMA", "SAIN", "SAJAN", "SAJAWAL", "SAJED", "SAJEEL", "SAJID", "SAJIDA", "SAJJAD", "SAJJID", "SAKANDAR", "SAKHAWAT", "SAKIHI", "SALAH", "SALAHUDDIN", "SALAM", "SALAMAT", "SALAMT", "SALEEM", "SALEH", "SALEHEEN", "SALIK", "SALIM", "SALMA", "SALMAN", "SAMAD", "SAMAN", "SAMAR", "SAMEED", "SAMEEN", "SAMEER", "SAMI", "SAMINA", "SAMI-UL-ISLAM", "SAMIULLAH", "SAMMUEL", "SAMNANI", "SAMO", "SAMRAN", "SAMREEN", "SAMUEL", "SANA", "SANAB", "SANAULLAH", "SANGI", "SANJAY", "SANTOSH", "SANYIA", "SAQIB", "SAQLAIN", "SARAH", "SARATH", "SARDAR", "SARFARAZ", "SARFRAZ", "SARMAD", "SARTAJ", "SARWAR", "SARWARI", "SATABO", "SATTAR", "SATTI", "SAUD", "SAVIO", "SAWAR", "SAYAD", "SEEMAB", "SEHAR", "SEHEEN", "SEHRISH", "SETHI", "SH", "SHA", "SHAAM", "SHABAN", "SHABANA", "SHABBIR", "SHABEEN", "SHABIR", "SHABRAIZ", "SHAD", "SHADAB", "SHAFAAT", "SHAFAQ", "SHAFAQAT", "SHAFAYAT", "SHAFEEQ", "SHAFEEQUE", "SHAFEH", "SHAFI", "SHAFIQ", "SHAFIQUE", "SHAFIQ-UR-", "SHAFIULLAH", "SHAFQAAT", "SHAFQAT", "SHAFQATULLAH", "SHAGUFTA", "SHAH", "SHAHAB", "SHAHABUDDIN", "SHAHANI", "SHAHAR", "SHAHBAN", "SHAHBAZ", "SHAHEEN", "SHAHEER", "SHAHERYAR", "SHAHI", "SHAHID", "SHAHIDA", "SHAHIDULLAH", "SHAHJAHAN", "SHAHMEER", "SHAHNAWAZ", "SHAHNAZ", "SHAHRAIZ", "SHAHROZ", "SHAHRUKH", "SHAHRYAR", "SHAHZAB", "SHAHZAD", "SHAHZADA", "SHAHZADI", "SHAHZAIB", "SHAHZEB", "SHAHZEIB", "SHAIKH", "SHAIR", "SHAIRAZ", "SHAKEEB", "SHAKEEL", "SHAKER", "SHAKIL", "SHAKIR", "SHAKOOR", "SHALOOM", "SHAMAOON", "SHAMAS", "SHAMI", "SHAMIM", "SHAMMAS", "SHAMOON", "SHAMRAIZ", "SHAMROZ", "SHAMS", "SHAMSHAD", "SHAMSHER", "SHAN", "SHANDAR", "SHANI", "SHARAFAT", "SHAREEF", "SHARIF", "SHARIQ", "SHARIQUE", "SHARIYAR", "SHARJEEL", "SHAROON", "SHAROZ", "SHARYAR", "SHAUKAT", "SHAUN", "SHAYAN", "SHAZAD", "SHAZAIB", "SHAZIA", "SHEEBA", "SHEER", "SHEERAN", "SHEERAZ", "SHEHAB", "SHEHARYAR", "SHEHBAZ", "SHEHERYAR", "SHEHROZ", "SHEHRYAR", "SHEHZAD", "SHEIKH", "SHENSHAH", "SHER", "SHERAN", "SHERAZ", "SHEREEN", "SHERJEEL", "SHERWANI", "SHIEKH", "SHIFA", "SHIRAZ", "SHOAIB", "SHOUKAT", "SHOUKET", "SHRYAR", "SHUJA", "SHUJAAT", "SHUJAH", "SHUJAHAT", "SHUMAILA", "SIBT", "SIBTAIN", "SIBTEY", "SIDDIQ", "SIDDIQI", "SIDDIQUE", "SIDDIQUI", "SIDDIQUIE", "SIDDQIUI", "SIDDQUE", "SIDIKI", "SIDIQUIE", "SIFTAIN", "SIKANDAR", "SIKANDER", "SIMRA", "SINGH", "SIRAJ", "SIRAJUDDIN", "SIYAB", "SIYAL", "SKINNER", "SMOORO", "SOBIA", "SOHAIB", "SOHAIL", "SOHRAB", "SOKHI", "SOLANGI", "SOLOMAN", "SONA", "SONU", "SOOMRO", "SOORI", "SUBHAN", "SUBHANI", "SUBTAIN", "SUFIAN", "SUFIYAN", "SUFYAN", "SUHA", "SUHAIL", "SULAIMAN", "SULAMAN", "SULEMAN", "SULMAN", "SULTAN", "SULTANA", "SUMAIR", "SUMAIRA", "SUMBUL", "SUMRA", "SUNEEL", "SUNIL", "SUNNY", "SYED", "SYEDA", "SYEDAIN", "SYES", "SYLVESTER", "TABAN", "TABANI", "TABARAK", "TABASSUM", "TABBASUM", "TABISH", "TABSUM", "TAHA", "TAHIR", "TAHIRA", "TAHSEEN", "TAIB", "TAIMOOR", "TAIMUR", "TAIYAB", "TAJ", "TAJAMUL", "TAJDAR", "TAJ-UD-DIN", "TALAL", "TALAT", "TALHA", "TALIB", "TAMEEZUDDIN", "TAMOOR", "TAMOUR", "TANVEER", "TANVER", "TANVIR", "TANZEEM", "TARIN", "TARIQ", "TASAB", "TASADDAQ", "TASADDUQ", "TASAWAR", "TASAWER", "TASLEEM", "TASNEEM", "TASSAWAR", "TAUFEEQ", "TAUFIQ", "TAUHEED", "TAUQEER", "TAUQIR", "TAUSEEF", "TAUSIF", "TAWAB", "TAYMOOR", "TAYYAB", "TAYYABA", "TAYYEB", "TEBANI", "TEHMINA", "TEHREEN", "TEHSEEN", "TEMOOR", "THATANI", "THOMAS", "TIRMIZI", "TOHEEB", "TOHEED", "TOOBA", "TOQEER", "TOSHEER", "TOSIQ", "TOUQEER", "TOUQIR", "TOUSEEF", "TUFAIL", "TUQEER", "TURAB", "TURK", "U", "UBAID", "UD", "UDDIN", "UL", "ULLAH", "UMAD", "UMAID", "UMAIR", "UMAIS", "UMAIZ", "UMAR", "UMAY", "UMEED", "UMER", "UMIAR", "UMMAR", "UMRANI", "UNAIB", "UR", "URF", "UROOJ", "UROOSA", "USAMA", "USMAN", "USMANI", "UZ", "UZAIR", "UZMA", "UZMAN", "VAQAS", "VICKY", "VICTOR", "VIJAY", "VIKRAMA", "WADIA", "WADOOD", "WAFA", "WAFFA", "WAHAB", "WAHAJ", "WAHEED", "WAHID", "WAJAHAT", "WAJID", "WAKEEL", "WALAYAT", "WALEED", "WALI", "WAQAR", "WAQAS", "WAQIF", "WARIS", "WARRAICH", "WARSI", "WASAY", "WASEEM", "WASEEMULLAH", "WASI", "WASIF", "WASIM", "WASIQ", "WATAN", "WAZEER", "WAZIR", "WILLIAM", "WISAL", "WISRAM", "XAVERITO", "YA", "YAHMAD", "YAHQOOB", "YAHYA", "YAISR", "YAKOOB", "YAMEEN", "YAMIN", "YAQOOB", "YAQUB", "YAR", "YASEEN", "YASIN", "YASIR", "YASMIN", "YASSER", "YAWAR", "YAZDAN", "YAZMAN", "YOUNAS", "YOUNIS", "YOUNS", "YOUNUS", "YOUSAF", "YOUSHA", "YOUSIF", "YOUSUF", "ZADA", "ZAFAR", "ZAFFAR", "ZAFIR", "ZAHEER", "ZAHEERUDDIN", "ZAHEER-UD-DIN", "ZAHER", "ZAHID", "ZAHIN", "ZAHIR", "ZAHOOR", "ZAI", "ZAIB", "ZAID", "ZAIDI", "ZAIGHAM", "ZAIGUM", "ZAIN", "ZAINAB", "ZAINULLAH", "ZAKAHULLAH", "ZAKAI", "ZAKI", "ZAKIR", "ZAKKI", "ZAKRIA", "ZAKWAN", "ZAMA", "ZAMAN", "ZAMAZ", "ZAMEER", "ZAMIN", "ZAMIR", "ZAMRAN", "ZANOB", "ZAR", "ZARAK", "ZARBAKHT", "ZARGHOON", "ZARKANI", "ZARNAB", "ZAROOF", "ZARYAB", "ZAWAR", "ZAYAD", "ZAYYAD", "ZEB", "ZEESHAN", "ZEHRA", "ZEIB", "ZESHAN", "ZIA", "ZIAFAT", "ZIARAF", "ZIAUDDIN", "ZIAULLAH", "ZILL", "ZOAIB", "ZOHAIB", "ZOHAIB-UR-RASHEED", "ZOHAIR", "ZOUR", "ZOYA", "ZUBAIR", "ZUBERI", "ZUBIA", "ZUFRAN", "ZUHAIB", "ZUHAIR", "ZUHIR", "ZULFIQAR", "ZULQARNAIN", "ZUNAIB"
    };
}


















