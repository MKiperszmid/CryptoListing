package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class USDX(
    @field:Json(name = "CHANGE24HOUR")
    val cHANGE24HOUR: Double,
    @field:Json(name = "CHANGEDAY")
    val cHANGEDAY: Double,
    @field:Json(name = "CHANGEHOUR")
    val cHANGEHOUR: Double,
    @field:Json(name = "CHANGEPCT24HOUR")
    val cHANGEPCT24HOUR: Double,
    @field:Json(name = "CHANGEPCTDAY")
    val cHANGEPCTDAY: Double,
    @field:Json(name = "CHANGEPCTHOUR")
    val cHANGEPCTHOUR: Double,
    @field:Json(name = "CIRCULATINGSUPPLY")
    val cIRCULATINGSUPPLY: Double,
    @field:Json(name = "CIRCULATINGSUPPLYMKTCAP")
    val cIRCULATINGSUPPLYMKTCAP: Double,
    @field:Json(name = "CONVERSIONSYMBOL")
    val cONVERSIONSYMBOL: String,
    @field:Json(name = "CONVERSIONTYPE")
    val cONVERSIONTYPE: String,
    @field:Json(name = "FLAGS")
    val fLAGS: String,
    @field:Json(name = "FROMSYMBOL")
    val fROMSYMBOL: String,
    @field:Json(name = "HIGH24HOUR")
    val hIGH24HOUR: Double,
    @field:Json(name = "HIGHDAY")
    val hIGHDAY: Double,
    @field:Json(name = "HIGHHOUR")
    val hIGHHOUR: Double,
    @field:Json(name = "IMAGEURL")
    val iMAGEURL: String,
    @field:Json(name = "LASTMARKET")
    val lASTMARKET: String,
    @field:Json(name = "LASTTRADEID")
    val lASTTRADEID: String,
    @field:Json(name = "LASTUPDATE")
    val lASTUPDATE: Int,
    @field:Json(name = "LASTVOLUME")
    val lASTVOLUME: Double,
    @field:Json(name = "LASTVOLUMETO")
    val lASTVOLUMETO: Double,
    @field:Json(name = "LOW24HOUR")
    val lOW24HOUR: Double,
    @field:Json(name = "LOWDAY")
    val lOWDAY: Double,
    @field:Json(name = "LOWHOUR")
    val lOWHOUR: Double,
    @field:Json(name = "MARKET")
    val mARKET: String,
    @field:Json(name = "MEDIAN")
    val mEDIAN: Double,
    @field:Json(name = "MKTCAP")
    val mKTCAP: Double,
    @field:Json(name = "MKTCAPPENALTY")
    val mKTCAPPENALTY: Int,
    @field:Json(name = "OPEN24HOUR")
    val oPEN24HOUR: Double,
    @field:Json(name = "OPENDAY")
    val oPENDAY: Double,
    @field:Json(name = "OPENHOUR")
    val oPENHOUR: Double,
    @field:Json(name = "PRICE")
    val pRICE: Double,
    @field:Json(name = "SUPPLY")
    val sUPPLY: Double,
    @field:Json(name = "TOPTIERVOLUME24HOUR")
    val tOPTIERVOLUME24HOUR: Double,
    @field:Json(name = "TOPTIERVOLUME24HOURTO")
    val tOPTIERVOLUME24HOURTO: Double,
    @field:Json(name = "TOSYMBOL")
    val tOSYMBOL: String,
    @field:Json(name = "TOTALTOPTIERVOLUME24H")
    val tOTALTOPTIERVOLUME24H: Double,
    @field:Json(name = "TOTALTOPTIERVOLUME24HTO")
    val tOTALTOPTIERVOLUME24HTO: Double,
    @field:Json(name = "TOTALVOLUME24H")
    val tOTALVOLUME24H: Double,
    @field:Json(name = "TOTALVOLUME24HTO")
    val tOTALVOLUME24HTO: Double,
    @field:Json(name = "TYPE")
    val tYPE: String,
    @field:Json(name = "VOLUME24HOUR")
    val vOLUME24HOUR: Double,
    @field:Json(name = "VOLUME24HOURTO")
    val vOLUME24HOURTO: Double,
    @field:Json(name = "VOLUMEDAY")
    val vOLUMEDAY: Double,
    @field:Json(name = "VOLUMEDAYTO")
    val vOLUMEDAYTO: Double,
    @field:Json(name = "VOLUMEHOUR")
    val vOLUMEHOUR: Double,
    @field:Json(name = "VOLUMEHOURTO")
    val vOLUMEHOURTO: Double
)