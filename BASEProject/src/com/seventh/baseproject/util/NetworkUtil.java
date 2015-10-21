package com.seventh.baseproject.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * 检查网络连接 <br/>
 * 1.网络是否连接 <br/>
 * 2.wifi是否打开 <br/>
 * 3.当前网络是否是wifi <br/>
 * 4.当前网络是否是3G <br/>
 */
public class NetworkUtil {
	/**
	 * 当前网络不可用
	 */
	public static final int NETWORK_NO = -1;
	/**
	 * 未知网络 
	 */
	public static final int NETWORK_CLASS_UNKNOWN = 0;
	/**
	 * 2G网络
	 */
	public static final int NETWORK_CLASS_2_G = 1;
	/**
	 * 3G网络
	 */
	public static final int NETWORK_CLASS_3_G = 2;
	/**
	 * 4G网络
	 */
	public static final int NETWORK_CLASS_4_G = 3;

	
	/**
	 * 判断网络是否连接
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		try {
			ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				NetworkInfo info = connectivity.getActiveNetworkInfo();
				if (info != null && info.isConnected()) {
					if (info.getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}


	/**
	 * wifi是否打开
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isWifiEnabled(Context context) {
		ConnectivityManager mgrConn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		TelephonyManager mgrTel = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return ((mgrConn.getActiveNetworkInfo() != null && mgrConn.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || mgrTel.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
	}


	/**
	 * 判断当前网络是否是wifi网络
	 * 
	 * @param context
	 * @return boolean
	 */
	public static boolean isWifi(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
			return true;
		}
		return false;
	}


	/**
	 * 判断当前网络是否是3G网络
	 * 
	 * @param context
	 * @return boolean
	 */
	public static boolean is3G(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取当前网路类型
	 * @param context
	 * @return
	 */
	public static int getNetworkClass(Context context){
		if(isNetworkAvailable(context)){
			ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
			String _strSubTypeName = activeNetInfo.getSubtypeName();
			int networkType = activeNetInfo.getSubtype();
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_CDMA:
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                case TelephonyManager.NETWORK_TYPE_IDEN:	//api<8 : replace by 11
                    return NETWORK_CLASS_2_G;
                case TelephonyManager.NETWORK_TYPE_UMTS:
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_EVDO_B:	//api<9 : replace by 14
                case TelephonyManager.NETWORK_TYPE_EHRPD:	//api<11 : replace by 12
                case TelephonyManager.NETWORK_TYPE_HSPAP:	//api<13 : replace by 15
                    return NETWORK_CLASS_3_G;
                case TelephonyManager.NETWORK_TYPE_LTE:		//api<11 : replace by 13
                    return NETWORK_CLASS_4_G;
                default:
                    // 中国移动 联通 电信 三种3G制式
                    if (_strSubTypeName.equalsIgnoreCase("TD-SCDMA") || _strSubTypeName.equalsIgnoreCase("WCDMA") || _strSubTypeName.equalsIgnoreCase("CDMA2000")) 
                    {
                        return NETWORK_CLASS_3_G;
                    }
                    else
                    {
                        return NETWORK_CLASS_UNKNOWN;
                    }
             }
		}else{
			return NETWORK_NO;
		}
	}
}
