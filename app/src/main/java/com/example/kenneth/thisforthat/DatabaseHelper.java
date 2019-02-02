package com.example.kenneth.thisforthat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.kenneth.thisforthat.SubBF.*;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper o_instance = null;
    public static final String DATABASE_NAME = "tot";
    public static final int DATABASE_VERSION = 1;
    public SQLiteDatabase o_db;
    public static final String USER_PASSWORD = "userpassword";
    public static List<String> onhand = new ArrayList<String> ();
    public static String[] arrOnhand;

    //tables common columns
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_STATUS = "selected";

    //tables for each cakes
    public static final String TABLE_BF = "tblBlackForest";
    public static final String TABLE_BC = "tblBlueberryCheesecake";
    public static final String TABLE_BM = "tblBrazodeMercedes";
    public static final String TABLE_CC = "tblChocolateCake";
    public static final String TABLE_CM = "tblChocolateMousse";
    public static final String TABLE_MC = "tblMochaCake";
    public static final String TABLE_RC = "tblRiceCake";
    public static final String TABLE_SC = "tblStrawberryCake";
    public static final String TABLE_UM = "tblUbeMacapuno";
    public static final String TABLE_VC = "tblVanillaCake";
    public static final String TABLE_USERING = "tblUserIng";

    public static final String DATABASE_BF = "CREATE TABLE " + TABLE_BF
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_BC = "CREATE TABLE " + TABLE_BC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_BM = "CREATE TABLE " + TABLE_BM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_CC = "CREATE TABLE " + TABLE_CC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_CM = "CREATE TABLE " + TABLE_CM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_MC = "CREATE TABLE " + TABLE_MC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_RC = "CREATE TABLE " + TABLE_RC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_SC = "CREATE TABLE " + TABLE_SC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_UM = "CREATE TABLE " + TABLE_UM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_VC = "CREATE TABLE " + TABLE_VC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    public static final String DATABASE_USERING = "CREATE TABLE " + TABLE_USERING
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_AMOUNT + " TEXT,"
            + KEY_STATUS + " INTEGER DEFAULT 0" + ")";

    //tables for process

    public static final String TABLE_PROCESS_BF = "tblProcessBF";
    public static final String TABLE_PROCESS_BC = "tblProcessBC";
    public static final String TABLE_PROCESS_BM = "tblProcessBM";
    public static final String TABLE_PROCESS_CC = "tblProcessCC";
    public static final String TABLE_PROCESS_CM = "tblProcessCM";
    public static final String TABLE_PROCESS_MC = "tblProcessMC";
    public static final String TABLE_PROCESS_RC = "tblProcessRC";
    public static final String TABLE_PROCESS_SC = "tblProcessSC";
    public static final String TABLE_PROCESS_UM = "tblProcessUM";
    public static final String TABLE_PROCESS_VC = "tblProcessVC";

    public static final String DATABASE_PROCESS_BF = "CREATE TABLE " + TABLE_PROCESS_BF
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_BC = "CREATE TABLE " + TABLE_PROCESS_BC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_BM = "CREATE TABLE " + TABLE_PROCESS_BM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_CC = "CREATE TABLE " + TABLE_PROCESS_CC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_CM = "CREATE TABLE " + TABLE_PROCESS_CM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_MC = "CREATE TABLE " + TABLE_PROCESS_MC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_RC = "CREATE TABLE " + TABLE_PROCESS_RC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_SC = "CREATE TABLE " + TABLE_PROCESS_SC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_UM = "CREATE TABLE " + TABLE_PROCESS_UM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_PROCESS_VC = "CREATE TABLE " + TABLE_PROCESS_VC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for blackforest
    public static final String TABLE_BF_MILK = "tblBFMilk";
    public static final String TABLE_BF_VINEGAR = "tblBFVinegar";
    public static final String TABLE_BF_FLOUR = "tblBFFlour";
    public static final String TABLE_BF_SUGAR = "tblBFSugar";
    public static final String TABLE_BF_COCOA = "tblBFCocoa";
    public static final String TABLE_BF_BAKINGPOWDER = "tblBFBakingPowder";
    public static final String TABLE_BF_BAKINGSODA = "tblBFBakingSoda";
    public static final String TABLE_BF_SALT = "tblBFSalt";
    public static final String TABLE_BF_EGG = "tblBFEgg";
    public static final String TABLE_BF_VEGETABLEOIL = "tblBFVegetableOil";
    public static final String TABLE_BF_COFFEE = "tblBFCoffee";
    public static final String TABLE_BF_VANILLA = "tblBFVanilla";
    public static final String TABLE_BF_CHERRYFILLING = "tblBFCherryFilling";
    public static final String TABLE_BF_CHERRYLIQUEUR = "tblBFCherryLiqueur";

    public static final String DATABASE_BF_MILK = "CREATE TABLE " + TABLE_BF_MILK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_VINEGAR = "CREATE TABLE " + TABLE_BF_VINEGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_FLOUR = "CREATE TABLE " + TABLE_BF_FLOUR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_SUGAR = "CREATE TABLE " + TABLE_BF_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_COCOA = "CREATE TABLE " + TABLE_BF_COCOA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_BAKINGPOWDER = "CREATE TABLE " + TABLE_BF_BAKINGPOWDER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_BAKINGSODA = "CREATE TABLE " + TABLE_BF_BAKINGSODA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_SALT = "CREATE TABLE " + TABLE_BF_SALT
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_EGG = "CREATE TABLE " + TABLE_BF_EGG
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_VEGETABLEOIL = "CREATE TABLE " + TABLE_BF_VEGETABLEOIL
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_COFFEE = "CREATE TABLE " + TABLE_BF_COFFEE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_VANILLA = "CREATE TABLE " + TABLE_BF_VANILLA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_CHERRYFILLING = "CREATE TABLE " + TABLE_BF_CHERRYFILLING
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BF_CHERRYLIQUEUR = "CREATE TABLE " + TABLE_BF_CHERRYLIQUEUR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for blueberry
    public static final String TABLE_BC_GRAHAMCRUMBS = "tblBCGrahamCrumbs";
    public static final String TABLE_BC_SUGAR = "tblBCSugar";
    public static final String TABLE_BC_BUTTER = "tblBCButter";
    public static final String TABLE_BC_CORNSTARCH = "tblBCCornstarch";
    public static final String TABLE_BC_CREAMCHEESE = "tblBCCreamCheese";
    public static final String TABLE_BC_SOURCREAM = "tblBCSourCream";
    public static final String TABLE_BC_VANILLA = "tblBCVanilla";
    public static final String TABLE_BC_EGG = "tblBCEgg";
    public static final String TABLE_BC_FLOUR = "tblBCFlour";
    public static final String TABLE_BC_BLUEBERRYJELLY = "tblBCBlueberryJelly";
    public static final String TABLE_BC_BLUEBERRYFROZEN = "tblBCBlueberryFrozen";

    public static final String DATABASE_BC_GRAHAMCRUMBS = "CREATE TABLE " + TABLE_BC_GRAHAMCRUMBS
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_SUGAR = "CREATE TABLE " + TABLE_BC_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_BUTTER = "CREATE TABLE " + TABLE_BC_BUTTER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_CORNSTARCH = "CREATE TABLE " + TABLE_BC_CORNSTARCH
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_CREAMCHEESE = "CREATE TABLE " + TABLE_BC_CREAMCHEESE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_SOURCREAM = "CREATE TABLE " + TABLE_BC_SOURCREAM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_VANILLA = "CREATE TABLE " + TABLE_BC_VANILLA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_EGG = "CREATE TABLE " + TABLE_BC_EGG
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_FLOUR = "CREATE TABLE " + TABLE_BC_FLOUR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_BLUEBERRYJELLY = "CREATE TABLE " + TABLE_BC_BLUEBERRYJELLY
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BC_BLUEBERRYFROZEN = "CREATE TABLE " + TABLE_BC_BLUEBERRYFROZEN
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for brazo de mercedes
    public static final String TABLE_BM_BUTTER = "tblBMButter";
    public static final String TABLE_BM_CONDENSEDMILK = "tblBMCondensedMilk";
    public static final String TABLE_BM_TARTARCREAM = "tblBMTartarCream";
    public static final String TABLE_BM_EGGWHITE = "tblBMEggWhite";
    public static final String TABLE_BM_EGGYOLK = "tblBMEggYolk";
    public static final String TABLE_BM_POWDEREDSUGAR = "tblBMPowderedSugar";
    public static final String TABLE_BM_VANILLA = "tblBMVanilla";
    public static final String TABLE_BM_SUGAR = "tblBMSugar";

    public static final String DATABASE_BM_BUTTER = "CREATE TABLE " + TABLE_BM_BUTTER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BM_CONDENSEDMILK = "CREATE TABLE " + TABLE_BM_CONDENSEDMILK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BM_TARTARCREAM = "CREATE TABLE " + TABLE_BM_TARTARCREAM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BM_EGGWHITE = "CREATE TABLE " + TABLE_BM_EGGWHITE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BM_EGGYOLK = "CREATE TABLE " + TABLE_BM_EGGYOLK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BM_POWDEREDSUGAR = "CREATE TABLE " + TABLE_BM_POWDEREDSUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BM_VANILLA = "CREATE TABLE " + TABLE_BM_VANILLA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_BM_SUGAR = "CREATE TABLE " + TABLE_BM_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for chocolate
    public static final String TABLE_CC_FLOUR = "tblCCFlour";
    public static final String TABLE_CC_BAKINGPOWDER = "tblCCBakingPowder";
    public static final String TABLE_CC_BAKINGSODA = "tblCBakingSoda";
    public static final String TABLE_CC_WATER = "tblCCWater";
    public static final String TABLE_CC_EGG = "tblCCEgg";
    public static final String TABLE_CC_MILK = "tblCCMilk";
    public static final String TABLE_CC_SALT = "tblCCSalt";
    public static final String TABLE_CC_COCOA = "tblCCCocoa";
    public static final String TABLE_CC_VANILLA = "tblCCVanilla";
    public static final String TABLE_CC_VEGETABLEOIL = "tblCCVegetableOil";
    public static final String TABLE_CC_SUGAR = "tblCCSugar";

    public static final String DATABASE_CC_FLOUR = "CREATE TABLE " + TABLE_CC_FLOUR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_BAKINGPOWDER = "CREATE TABLE " + TABLE_CC_BAKINGPOWDER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_BAKINGSODA = "CREATE TABLE " + TABLE_CC_BAKINGSODA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_WATER = "CREATE TABLE " + TABLE_CC_WATER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_EGG = "CREATE TABLE " + TABLE_CC_EGG
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_MILK = "CREATE TABLE " + TABLE_CC_MILK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_SALT = "CREATE TABLE " + TABLE_CC_SALT
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_COCOA = "CREATE TABLE " + TABLE_CC_COCOA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_VANILLA = "CREATE TABLE " + TABLE_CC_VANILLA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_VEGETABLEOIL = "CREATE TABLE " + TABLE_CC_VEGETABLEOIL
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CC_SUGAR = "CREATE TABLE " + TABLE_CC_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for chocolate mousse
    public static final String TABLE_CM_CHOCOLATECHIP = "tblCMChocolateChip";
    public static final String TABLE_CM_EGG = "tblCMEgg";
    public static final String TABLE_CM_EGGWHITE = "tblCMEggWhite";
    public static final String TABLE_CM_WHIPPEDCREAM = "tblCMWhippedCream";
    public static final String TABLE_CM_LADYFINGER = "tblCMLadyfinger";

    public static final String DATABASE_CM_CHOCOLATECHIP = "CREATE TABLE " + TABLE_CM_CHOCOLATECHIP
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CM_EGG = "CREATE TABLE " + TABLE_CM_EGG
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CM_EGGWHITE = "CREATE TABLE " + TABLE_CM_EGGWHITE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CM_WHIPPEDCREAM = "CREATE TABLE " + TABLE_CM_WHIPPEDCREAM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_CM_LADYFINGER = "CREATE TABLE " + TABLE_CM_LADYFINGER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for mocha
    public static final String TABLE_MC_FLOUR = "tblMCFlour";
    public static final String TABLE_MC_BAKINGPOWDER = "tblMCBakingPowder";
    public static final String TABLE_MC_COFFEE = "tblMCCoffee";
    public static final String TABLE_MC_COOKINGOIL = "tblMCCookingOil";
    public static final String TABLE_MC_TARTARCREAM = "tblMCTartarCream";
    public static final String TABLE_MC_EGGWHITE = "tblMCEggWhite";
    public static final String TABLE_MC_EGGYOLK = "tblMCEggYolk";
    public static final String TABLE_MC_SALT = "tblMCSalt";
    public static final String TABLE_MC_SUGAR = "tblMCSugar";

    public static final String DATABASE_MC_FLOUR = "CREATE TABLE " + TABLE_MC_FLOUR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_MC_BAKINGPOWDER = "CREATE TABLE " + TABLE_MC_BAKINGPOWDER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_MC_COFFEE = "CREATE TABLE " + TABLE_MC_COFFEE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_MC_COOKINGOIL = "CREATE TABLE " + TABLE_MC_COOKINGOIL
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_MC_TARTARCREAM = "CREATE TABLE " + TABLE_MC_TARTARCREAM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_MC_EGGWHITE = "CREATE TABLE " + TABLE_MC_EGGWHITE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_MC_EGGYOLK = "CREATE TABLE " + TABLE_MC_EGGYOLK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_MC_SALT = "CREATE TABLE " + TABLE_MC_SALT
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_MC_SUGAR = "CREATE TABLE " + TABLE_MC_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for rice
    public static final String TABLE_RC_FLOUR = "tblRCFlour";
    public static final String TABLE_RC_BAKINGPOWDER = "tblRCBakingPowder";
    public static final String TABLE_RC_EDAMCHEESE = "tblRCEdamCheese";
    public static final String TABLE_RC_EGG = "tblRCEgg";
    public static final String TABLE_RC_EVAPORATEDMILK = "tblRCEvaporatedMilk";
    public static final String TABLE_RC_WATER = "tblRCWater";
    public static final String TABLE_RC_SUGAR = "tblRCSugar";

    public static final String DATABASE_RC_FLOUR = "CREATE TABLE " + TABLE_RC_FLOUR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_RC_BAKINGPOWDER = "CREATE TABLE " + TABLE_RC_BAKINGPOWDER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_RC_EDAMCHEESE = "CREATE TABLE " + TABLE_RC_EDAMCHEESE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_RC_EGG = "CREATE TABLE " + TABLE_RC_EGG
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_RC_EVAPORATEDMILK = "CREATE TABLE " + TABLE_RC_EVAPORATEDMILK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_RC_WATER = "CREATE TABLE " + TABLE_RC_WATER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_RC_SUGAR = "CREATE TABLE " + TABLE_RC_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for strawberry
    public static final String TABLE_SC_CONDENSEDMILK = "tblSCCondensedMilk";
    public static final String TABLE_SC_CORNSTARCH = "tblSCCornstarch";
    public static final String TABLE_SC_CREAMCHEESE = "tblSCCreamCheese";
    public static final String TABLE_SC_EGG = "tblSCEgg";
    public static final String TABLE_SC_GRAHAMCRUMBS = "tblSCGrahamCrumbs";
    public static final String TABLE_SC_GROUNDCINNAMON = "tblSCGroundCinnamon";
    public static final String TABLE_SC_LEMON = "tblSCLemon";
    public static final String TABLE_SC_BUTTER = "tblSCButter";
    public static final String TABLE_SC_STRAWBERRY = "tblSCStrawberry";
    public static final String TABLE_SC_VANILLA = "tblSCVanilla";
    public static final String TABLE_SC_WATER = "tblSCWater";
    public static final String TABLE_SC_SUGAR = "tblSCSugar";

    public static final String DATABASE_SC_CONDENSEDMILK = "CREATE TABLE " + TABLE_SC_CONDENSEDMILK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_CORNSTRACH = "CREATE TABLE " + TABLE_SC_CORNSTARCH
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_CREAMCHEESE = "CREATE TABLE " + TABLE_SC_CREAMCHEESE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_EGG = "CREATE TABLE " + TABLE_SC_EGG
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_GRAHAMCRUMBS = "CREATE TABLE " + TABLE_SC_GRAHAMCRUMBS
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_GROUNDCINNAMON = "CREATE TABLE " + TABLE_SC_GROUNDCINNAMON
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_LEMON = "CREATE TABLE " + TABLE_SC_LEMON
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_BUTTER = "CREATE TABLE " + TABLE_SC_BUTTER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_STRAWBERRY = "CREATE TABLE " + TABLE_SC_STRAWBERRY
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_VANILLA = "CREATE TABLE " + TABLE_SC_VANILLA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_WATER = "CREATE TABLE " + TABLE_SC_WATER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_SC_SUGAR = "CREATE TABLE " + TABLE_SC_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for ube
    public static final String TABLE_UM_BAKINGPOWDER = "tblUMBakingPowder";
    public static final String TABLE_UM_BLUECOLOR = "tblUMBlueColor";
    public static final String TABLE_UM_CAKEFLOUR = "tblUMCakeFlour";
    public static final String TABLE_UM_CORNSYRUP = "tblUMCornSyrup";
    public static final String TABLE_UM_TARTARCREAM = "tblUMTartarCream";
    public static final String TABLE_UM_EGGWHITE = "tblUMEggWhite";
    public static final String TABLE_UM_EGGYOLK = "tblUMEggYolk";
    public static final String TABLE_UM_EVAPORATEDMILK = "tblUMEvaporatedMilk";
    public static final String TABLE_UM_MACAPUNO = "tblUMMacapuno";
    public static final String TABLE_UM_MILK = "tblUMMilk";
    public static final String TABLE_UM_REDCOLOR = "tblUMRedColor";
    public static final String TABLE_UM_SALT = "tblUMSalt";
    public static final String TABLE_UM_BUTTER = "tblUMButter";
    public static final String TABLE_UM_UBEYAM = "tblUMUbeYam";
    public static final String TABLE_UM_VANILLA = "tblUMVanilla";
    public static final String TABLE_UM_VEGETABLEOIL = "tblUMVegetableOil";
    public static final String TABLE_UM_VIOLETCOLOR = "tblUMVioletColor";
    public static final String TABLE_UM_SUGAR = "tblUMSugar";

    public static final String DATABASE_UM_BAKINGPOWDER = "CREATE TABLE " + TABLE_UM_BAKINGPOWDER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_BLUECOLOR = "CREATE TABLE " + TABLE_UM_BLUECOLOR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_CAKEFLOUR = "CREATE TABLE " + TABLE_UM_CAKEFLOUR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_CORNSYRUP = "CREATE TABLE " + TABLE_UM_CORNSYRUP
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_TARTARCREAM = "CREATE TABLE " + TABLE_UM_TARTARCREAM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_EGGWHITE = "CREATE TABLE " + TABLE_UM_EGGWHITE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_EGGYOLK = "CREATE TABLE " + TABLE_UM_EGGYOLK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_EVAPORATEDMILK = "CREATE TABLE " + TABLE_UM_EVAPORATEDMILK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_MACAPUNO = "CREATE TABLE " + TABLE_UM_MACAPUNO
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_MILK = "CREATE TABLE " + TABLE_UM_MILK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_REDCOLOR = "CREATE TABLE " + TABLE_UM_REDCOLOR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_SALT = "CREATE TABLE " + TABLE_UM_SALT
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_BUTTER = "CREATE TABLE " + TABLE_UM_BUTTER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_UBEYAM = "CREATE TABLE " + TABLE_UM_UBEYAM
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_VANILLA = "CREATE TABLE " + TABLE_UM_VANILLA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_VEGETABLEOIL = "CREATE TABLE " + TABLE_UM_VEGETABLEOIL
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_VIOLETCOLOR = "CREATE TABLE " + TABLE_UM_VIOLETCOLOR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_UM_SUGAR = "CREATE TABLE " + TABLE_UM_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    //sub for vanilla
    public static final String TABLE_VC_FLOUR = "tblVCFlour";
    public static final String TABLE_VC_BUTTER = "tblVCButter";
    public static final String TABLE_VC_EGG = "tblVCEgg";
    public static final String TABLE_VC_EVAPORATEDMILK = "tblVCEvaporatedMilk";
    public static final String TABLE_VC_SHORTENING = "tblVCShortening";
    public static final String TABLE_VC_VANILLA = "tblVCVanilla";
    public static final String TABLE_VC_WATER = "tblVCWater";
    public static final String TABLE_VC_SUGAR = "tblVCSugar";

    public static final String DATABASE_VC_FLOUR = "CREATE TABLE " + TABLE_VC_FLOUR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_VC_BUTTER = "CREATE TABLE " + TABLE_VC_BUTTER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_VC_EGG = "CREATE TABLE " + TABLE_VC_EGG
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_VC_EVAPORATEDMILK = "CREATE TABLE " + TABLE_VC_EVAPORATEDMILK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_VC_SHORTENING = "CREATE TABLE " + TABLE_VC_SHORTENING
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_VC_VANILLA = "CREATE TABLE " + TABLE_VC_VANILLA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_VC_WATER = "CREATE TABLE " + TABLE_VC_WATER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";

    public static final String DATABASE_VC_SUGAR = "CREATE TABLE " + TABLE_VC_SUGAR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT " + ")";


    public DatabaseHelper() {
        super(AndroidContext.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
        o_db = getWritableDatabase();
    }

    public static DatabaseHelper getInstance() {
        if (o_instance == null) {
            o_instance = new DatabaseHelper();
        }
        return o_instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DATABASE_BF);
            db.execSQL(DATABASE_BC);
            db.execSQL(DATABASE_BM);
            db.execSQL(DATABASE_CC);
            db.execSQL(DATABASE_CM);
            db.execSQL(DATABASE_MC);
            db.execSQL(DATABASE_RC);
            db.execSQL(DATABASE_SC);
            db.execSQL(DATABASE_UM);
            db.execSQL(DATABASE_VC);
            db.execSQL(DATABASE_USERING);

            db.execSQL (DATABASE_PROCESS_BF);
            db.execSQL (DATABASE_PROCESS_BC);
            db.execSQL (DATABASE_PROCESS_BM);
            db.execSQL (DATABASE_PROCESS_CC);
            db.execSQL (DATABASE_PROCESS_CM);
            db.execSQL (DATABASE_PROCESS_MC);
            db.execSQL (DATABASE_PROCESS_RC);
            db.execSQL (DATABASE_PROCESS_SC);
            db.execSQL (DATABASE_PROCESS_UM);
            db.execSQL (DATABASE_PROCESS_VC);

            //db for sub ing in table blackforest
            db.execSQL (DATABASE_BF_MILK);
            db.execSQL (DATABASE_BF_VINEGAR);
            db.execSQL (DATABASE_BF_FLOUR);
            db.execSQL (DATABASE_BF_SUGAR);
            db.execSQL (DATABASE_BF_COCOA);
            db.execSQL (DATABASE_BF_BAKINGPOWDER);
            db.execSQL (DATABASE_BF_BAKINGSODA);
            db.execSQL (DATABASE_BF_SALT);
            db.execSQL (DATABASE_BF_EGG);
            db.execSQL (DATABASE_BF_VEGETABLEOIL);
            db.execSQL (DATABASE_BF_COFFEE);
            db.execSQL (DATABASE_BF_VANILLA);
            db.execSQL (DATABASE_BF_CHERRYFILLING);
            db.execSQL (DATABASE_BF_CHERRYLIQUEUR);

            //db for sub ing in table blueberry
            db.execSQL (DATABASE_BC_GRAHAMCRUMBS);
            db.execSQL (DATABASE_BC_SUGAR);
            db.execSQL (DATABASE_BC_BUTTER);
            db.execSQL (DATABASE_BC_CORNSTARCH);
            db.execSQL (DATABASE_BC_CREAMCHEESE);
            db.execSQL (DATABASE_BC_SOURCREAM);
            db.execSQL (DATABASE_BC_VANILLA);
            db.execSQL (DATABASE_BC_EGG);
            db.execSQL (DATABASE_BC_FLOUR);
            db.execSQL (DATABASE_BC_BLUEBERRYJELLY);
            db.execSQL (DATABASE_BC_BLUEBERRYFROZEN);

            //db for sub ing in table brazo
            db.execSQL (DATABASE_BM_BUTTER);
            db.execSQL (DATABASE_BM_CONDENSEDMILK);
            db.execSQL (DATABASE_BM_TARTARCREAM);
            db.execSQL (DATABASE_BM_EGGWHITE);
            db.execSQL (DATABASE_BM_EGGYOLK);
            db.execSQL (DATABASE_BM_POWDEREDSUGAR);
            db.execSQL (DATABASE_BM_VANILLA);
            db.execSQL (DATABASE_BM_SUGAR);

            //db for sub ing in table chocolate
            db.execSQL (DATABASE_CC_FLOUR);
            db.execSQL (DATABASE_CC_BAKINGPOWDER);
            db.execSQL (DATABASE_CC_BAKINGSODA);
            db.execSQL (DATABASE_CC_WATER);
            db.execSQL (DATABASE_CC_EGG);
            db.execSQL (DATABASE_CC_MILK);
            db.execSQL (DATABASE_CC_SALT);
            db.execSQL (DATABASE_CC_COCOA);
            db.execSQL (DATABASE_CC_VANILLA);
            db.execSQL (DATABASE_CC_VEGETABLEOIL);
            db.execSQL (DATABASE_CC_SUGAR);

            //db for sub ing in table chocolate mousse
            db.execSQL (DATABASE_CM_CHOCOLATECHIP);
            db.execSQL (DATABASE_CM_EGG);
            db.execSQL (DATABASE_CM_EGGWHITE);
            db.execSQL (DATABASE_CM_WHIPPEDCREAM);
            db.execSQL (DATABASE_CM_LADYFINGER);

            //db for sub ing in table mocha
            db.execSQL (DATABASE_MC_FLOUR);
            db.execSQL (DATABASE_MC_BAKINGPOWDER);
            db.execSQL (DATABASE_MC_COFFEE);
            db.execSQL (DATABASE_MC_COOKINGOIL);
            db.execSQL (DATABASE_MC_TARTARCREAM);
            db.execSQL (DATABASE_MC_EGGWHITE);
            db.execSQL (DATABASE_MC_EGGYOLK);
            db.execSQL (DATABASE_MC_SALT);
            db.execSQL (DATABASE_MC_SUGAR);

            //db for sub ing in table rice
            db.execSQL (DATABASE_RC_FLOUR);
            db.execSQL (DATABASE_RC_BAKINGPOWDER);
            db.execSQL (DATABASE_RC_EDAMCHEESE);
            db.execSQL (DATABASE_RC_EGG);
            db.execSQL (DATABASE_RC_EVAPORATEDMILK);
            db.execSQL (DATABASE_RC_WATER);
            db.execSQL (DATABASE_RC_SUGAR);

            //db for sub ing in table strawberry
            db.execSQL (DATABASE_SC_CONDENSEDMILK);
            db.execSQL (DATABASE_SC_CORNSTRACH);
            db.execSQL (DATABASE_SC_CREAMCHEESE);
            db.execSQL (DATABASE_SC_EGG);
            db.execSQL (DATABASE_SC_GRAHAMCRUMBS);
            db.execSQL (DATABASE_SC_GROUNDCINNAMON);
            db.execSQL (DATABASE_SC_LEMON);
            db.execSQL (DATABASE_SC_BUTTER);
            db.execSQL (DATABASE_SC_STRAWBERRY);
            db.execSQL (DATABASE_SC_VANILLA);
            db.execSQL (DATABASE_SC_WATER);
            db.execSQL (DATABASE_SC_SUGAR);

            //db for sub ing in table ube
            db.execSQL (DATABASE_UM_BAKINGPOWDER);
            db.execSQL (DATABASE_UM_BLUECOLOR);
            db.execSQL (DATABASE_UM_CAKEFLOUR);
            db.execSQL (DATABASE_UM_CORNSYRUP);
            db.execSQL (DATABASE_UM_TARTARCREAM);
            db.execSQL (DATABASE_UM_EGGWHITE);
            db.execSQL (DATABASE_UM_EGGYOLK);
            db.execSQL (DATABASE_UM_EVAPORATEDMILK);
            db.execSQL (DATABASE_UM_MACAPUNO);
            db.execSQL (DATABASE_UM_MILK);
            db.execSQL (DATABASE_UM_REDCOLOR);
            db.execSQL (DATABASE_UM_SALT);
            db.execSQL (DATABASE_UM_BUTTER);
            db.execSQL (DATABASE_UM_UBEYAM);
            db.execSQL (DATABASE_UM_VANILLA);
            db.execSQL (DATABASE_UM_VEGETABLEOIL);
            db.execSQL (DATABASE_UM_VIOLETCOLOR);
            db.execSQL (DATABASE_UM_SUGAR);

            //db for sub in ing table vanilla
            db.execSQL (DATABASE_VC_FLOUR);
            db.execSQL (DATABASE_VC_BUTTER);
            db.execSQL (DATABASE_VC_EGG);
            db.execSQL (DATABASE_VC_EVAPORATEDMILK);
            db.execSQL (DATABASE_VC_SHORTENING);
            db.execSQL (DATABASE_VC_VANILLA);
            db.execSQL (DATABASE_VC_WATER);
            db.execSQL (DATABASE_VC_SUGAR);

        }
        catch (Exception e) {
            Log.e("ERROR", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_BF);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_BC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_BM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_RC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_UM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_VC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERING);

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_BF);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_BC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_BM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_CC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_CM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_MC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_RC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_SC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_UM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROCESS_VC);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_MILK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_VINEGAR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_FLOUR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_SUGAR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_COCOA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_BAKINGPOWDER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_BAKINGSODA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_SALT);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_EGG);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_VEGETABLEOIL);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_COFFEE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_VANILLA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_CHERRYFILLING);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BF_CHERRYLIQUEUR);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_GRAHAMCRUMBS);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_SUGAR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_BUTTER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_CORNSTARCH);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_CREAMCHEESE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_SOURCREAM);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_VANILLA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_EGG);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_FLOUR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_BLUEBERRYJELLY);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BC_BLUEBERRYFROZEN);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BM_BUTTER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BM_CONDENSEDMILK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BM_TARTARCREAM);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BM_EGGWHITE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BM_EGGYOLK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BM_POWDEREDSUGAR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BM_VANILLA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_BM_SUGAR);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_FLOUR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_BAKINGPOWDER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_BAKINGSODA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_WATER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_EGG);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_MILK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_SALT);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_COCOA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_VANILLA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_VEGETABLEOIL);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CC_SUGAR);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CM_CHOCOLATECHIP);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CM_EGG);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CM_EGGWHITE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CM_WHIPPEDCREAM);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_CM_LADYFINGER);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_FLOUR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_BAKINGPOWDER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_COFFEE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_COOKINGOIL);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_TARTARCREAM);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_EGGWHITE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_EGGYOLK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_SALT);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_MC_SUGAR);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_RC_FLOUR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_RC_BAKINGPOWDER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_RC_EDAMCHEESE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_RC_EGG);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_RC_EVAPORATEDMILK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_RC_WATER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_RC_SUGAR);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_CONDENSEDMILK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_CORNSTARCH);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_CREAMCHEESE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_EGG);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_GRAHAMCRUMBS);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_GROUNDCINNAMON);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_LEMON);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_BUTTER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_STRAWBERRY);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_VANILLA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_WATER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_SC_SUGAR);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_BAKINGPOWDER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_BLUECOLOR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_CAKEFLOUR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_CORNSYRUP);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_TARTARCREAM);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_EGGWHITE);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_EGGYOLK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_EVAPORATEDMILK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_MACAPUNO);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_MILK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_REDCOLOR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_SALT);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_BUTTER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_UBEYAM);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_VANILLA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_VEGETABLEOIL);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_VIOLETCOLOR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_UM_SUGAR);

        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_VC_FLOUR);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_VC_BUTTER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_VC_EGG);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_VC_EVAPORATEDMILK);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_VC_SHORTENING);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_VC_VANILLA);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_VC_WATER);
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE_VC_SUGAR);

        onCreate(db);
    }

    public SQLiteDatabase getDb() {
        return o_db;
    }

    public void queueNameBF(){
        Cursor cursor = o_db.query(TABLE_BF, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_BF, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
        /*
        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/
    }

    public String queueAllBF(){
        Cursor cursor = o_db.query(TABLE_BF, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameBC(){
        Cursor cursor = o_db.query(TABLE_BC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_BC, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllBC(){
        Cursor cursor = o_db.query(TABLE_BC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameBM(){
        Cursor cursor = o_db.query(TABLE_BM, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_BM, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllBM(){
        Cursor cursor = o_db.query(TABLE_BM, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameCC(){
        Cursor cursor = o_db.query(TABLE_CC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_CC, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllCC(){
        Cursor cursor = o_db.query(TABLE_CC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameCM(){
        Cursor cursor = o_db.query(TABLE_CM, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_CM, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllCM(){
        Cursor cursor = o_db.query(TABLE_CM, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameMC(){
        Cursor cursor = o_db.query(TABLE_MC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_MC, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllMC(){
        Cursor cursor = o_db.query(TABLE_MC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameRC(){
        Cursor cursor = o_db.query(TABLE_RC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_RC, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllRC(){
        Cursor cursor = o_db.query(TABLE_RC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameSC(){
        Cursor cursor = o_db.query(TABLE_SC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_SC, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllSC(){
        Cursor cursor = o_db.query(TABLE_SC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameUM(){
        Cursor cursor = o_db.query(TABLE_UM, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_UM, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllUM(){
        Cursor cursor = o_db.query(TABLE_UM, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }

    public void queueNameVC(){
        Cursor cursor = o_db.query(TABLE_VC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        missing.clear ();
        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            String a = cursor.getString(index_AMOUNT);
            String n = cursor.getString(index_NAME);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            missing.add(amount+" "+name);
        }

        Cursor cursor1 = o_db.query(TABLE_VC, new String[]{"_id","name","amount","selected"}, "selected = 1", null, null, null, "name asc");

        onhand.clear ();
        int index_AMOUNT1 = cursor1.getColumnIndex(KEY_AMOUNT);
        int index_NAME1 = cursor1.getColumnIndex(KEY_NAME);
        for(cursor1.moveToFirst(); !(cursor1.isAfterLast()); cursor1.moveToNext()){
            String a = cursor1.getString(index_AMOUNT1);
            String n = cursor1.getString(index_NAME1);
            String amount = a.toLowerCase ();
            String name = n.toLowerCase ();
            onhand.add(amount+" "+name);
        }
    }

    public String queueAllVC(){
        Cursor cursor = o_db.query(TABLE_VC, new String[]{"_id","name","amount","selected"}, "selected = 0", null, null, null, "name asc");

        String result = "";

        int index_AMOUNT = cursor.getColumnIndex(KEY_AMOUNT);
        int index_NAME = cursor.getColumnIndex(KEY_NAME);
        /*for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
            result = result + cursor.getString(index_CONTENT) + "\n";
        }*/

        if (cursor!=null){
            cursor.moveToFirst();
            result = result + cursor.getString(index_AMOUNT) + " " + cursor.getString(index_NAME) + "\n";
        }

        return result;
    }
}