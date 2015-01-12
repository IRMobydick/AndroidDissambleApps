package com.ubercab.client.core.metrics.analytics;

import com.ubercab.library.metrics.analytics.event.CustomEventName;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.metrics.analytics.event.TapEventName;

public final class RiderEvents
{
  public static enum Custom
    implements CustomEventName
  {
    static
    {
      Custom[] arrayOfCustom = new Custom[5];
      arrayOfCustom[0] = SIGN_UP_LOAD_PROFILE_HAS_EMAIL;
      arrayOfCustom[1] = SIGN_UP_LOAD_PROFILE_HAS_FIRST_NAME;
      arrayOfCustom[2] = SIGN_UP_LOAD_PROFILE_HAS_LAST_NAME;
      arrayOfCustom[3] = SIGN_UP_LOAD_PROFILE_HAS_PHONE;
      arrayOfCustom[4] = SIGN_UP_PAYMENT_PROMO_APPLIED;
    }
  }

  public static enum Impression
    implements ImpressionEventName
  {
    static
    {
      Impression[] arrayOfImpression = new Impression[55];
      arrayOfImpression[0] = ACCEPTED;
      arrayOfImpression[1] = ARREARS_BALANCE_PAID;
      arrayOfImpression[2] = ARREARS_WALLET_ADD_FUNDS_INSUFFICIENT;
      arrayOfImpression[3] = ARRIVING_NOW;
      arrayOfImpression[4] = CARDIO;
      arrayOfImpression[5] = CONFIRMING;
      arrayOfImpression[6] = DESTINATION_SET_PRE_DISPATCH;
      arrayOfImpression[7] = DISPATCHING;
      arrayOfImpression[8] = EXPENSE_INFO;
      arrayOfImpression[9] = FAVORITES_ADD;
      arrayOfImpression[10] = FAVORITES_SAVED;
      arrayOfImpression[11] = LEGAL;
      arrayOfImpression[12] = LOOKING;
      arrayOfImpression[13] = MAGIC;
      arrayOfImpression[14] = MAP_VIEW;
      arrayOfImpression[15] = MOBILE_MESSAGE;
      arrayOfImpression[16] = ON_TRIP;
      arrayOfImpression[17] = PAYMENT_LIST_ARREARS;
      arrayOfImpression[18] = PAYMENT_LIST_CHANGE;
      arrayOfImpression[19] = PAYMENT_LIST_EDIT;
      arrayOfImpression[20] = PAYMENT_LIST_SELECT;
      arrayOfImpression[21] = PAYMENT_METHOD_ADD_CC;
      arrayOfImpression[22] = PAYMENT_METHOD_ADD_PAYPAL;
      arrayOfImpression[23] = PAYMENT_METHOD_DELETE_CONFIRMATION;
      arrayOfImpression[24] = PAYMENT_METHOD_DELETE_SUCCESS;
      arrayOfImpression[25] = PAYMENT_METHOD_DETAIL;
      arrayOfImpression[26] = PAYMENT_METHOD_DETAIL_TRIP_BALANCE;
      arrayOfImpression[27] = PAYMENT_METHOD_LINK_PAYTM;
      arrayOfImpression[28] = PICKUP_LOCATION_SNAPPED;
      arrayOfImpression[29] = PRIVACY_POLICY;
      arrayOfImpression[30] = PRODUCT_LOAD_ON_MAP;
      arrayOfImpression[31] = PROMO_CODE_ENTER;
      arrayOfImpression[32] = SEARCH_DROPOFF_SUGGESTIONS;
      arrayOfImpression[33] = SEARCH_PICKUP_SUGGESTIONS;
      arrayOfImpression[34] = SELECT_COUNTRY;
      arrayOfImpression[35] = SIGN_IN;
      arrayOfImpression[36] = SIGN_UP_1;
      arrayOfImpression[37] = SIGN_UP_2;
      arrayOfImpression[38] = SIGN_UP_INDIA_PAYMENT_CHOICE;
      arrayOfImpression[39] = SIGN_UP_PAYMENT_ERROR_DIALOG;
      arrayOfImpression[40] = SPLASH;
      arrayOfImpression[41] = SURGE_DROP_NOTIFY_RECEIVED;
      arrayOfImpression[42] = SURGE_PRICING;
      arrayOfImpression[43] = SURGE_SOBRIETY_CHECK;
      arrayOfImpression[44] = TERMS_AND_CONDITIONS;
      arrayOfImpression[45] = TRIP_CANCEL_CONFIRMATION;
      arrayOfImpression[46] = WALLET_EDIT;
      arrayOfImpression[47] = WALLET_EDIT_OPTIONS;
      arrayOfImpression[48] = WALLET_FUND;
      arrayOfImpression[49] = WALLET_FUND_3DS_ADD;
      arrayOfImpression[50] = WALLET_FUND_ADD_MONEY;
      arrayOfImpression[51] = WALLET_LOW_BALANCE_ALERT;
      arrayOfImpression[52] = WALLET_OTP_AUTH;
      arrayOfImpression[53] = WALLET_OTP_AUTH_FAILURE;
      arrayOfImpression[54] = WALLET_OTP_AUTH_SUCCESS;
    }
  }

  public static enum Tap
    implements TapEventName
  {
    static
    {
      Tap[] arrayOfTap = new Tap[117];
      arrayOfTap[0] = ARREARS_ADD_PAYMENT_METHOD;
      arrayOfTap[1] = ARREARS_WALLET;
      arrayOfTap[2] = CONFIRMATION_CANCEL;
      arrayOfTap[3] = CONTACT_DRIVER_OPEN;
      arrayOfTap[4] = CONTACT_DRIVER_TEXT;
      arrayOfTap[5] = CONTACT_DRIVER_VOICE;
      arrayOfTap[6] = DESTINATION_REMOVE;
      arrayOfTap[7] = DISPATCH_CANCEL;
      arrayOfTap[8] = EDIT_WALLET_ADD_MONEY;
      arrayOfTap[9] = EDIT_WALLET_DELETE;
      arrayOfTap[10] = EDIT_WALLET_EDIT;
      arrayOfTap[11] = EXPENSE_BUTTON_PAYMENT;
      arrayOfTap[12] = EXPENSE_INFO_CANCEL;
      arrayOfTap[13] = EXPENSE_INFO_SAVE;
      arrayOfTap[14] = FARE_ESTIMATE_DISMISS_INFO;
      arrayOfTap[15] = FARE_ESTIMATE_OPEN_INFO;
      arrayOfTap[16] = FARE_SPLIT_ACCEPT;
      arrayOfTap[17] = FARE_SPLIT_CANCEL;
      arrayOfTap[18] = FARE_SPLIT_OPEN;
      arrayOfTap[19] = FARE_SPLIT_REJECT;
      arrayOfTap[20] = FARE_SPLIT_REMOVE_RECIPIENT;
      arrayOfTap[21] = FARE_SPLIT_REMOVE_SELF;
      arrayOfTap[22] = FARE_SPLIT_SEND;
      arrayOfTap[23] = FAVORITES_REMOVE;
      arrayOfTap[24] = MAP_CENTER_BUTTON;
      arrayOfTap[25] = MAP_PAN;
      arrayOfTap[26] = MENU_CLOSE;
      arrayOfTap[27] = MENU_OPEN;
      arrayOfTap[28] = MOBILE_MESSAGE_BROWSE;
      arrayOfTap[29] = MOBILE_MESSAGE_CONFIRM;
      arrayOfTap[30] = MOBILE_MESSAGE_DISMISS;
      arrayOfTap[31] = MOBILE_MESSAGE_OPEN_PAYMENT;
      arrayOfTap[32] = MOBILE_MESSAGE_OPEN_PROFILE;
      arrayOfTap[33] = MOBILE_MESSAGE_SHARE;
      arrayOfTap[34] = PAYMENT_APPLY_CREDITS_TOGGLE;
      arrayOfTap[35] = PAYMENT_BUTTON_CONFIRM;
      arrayOfTap[36] = PAYMENT_BUTTON_MENU;
      arrayOfTap[37] = PAYMENT_BUTTON_TRIP;
      arrayOfTap[38] = PAYMENT_LIST_METHOD_ARREARS;
      arrayOfTap[39] = PAYMENT_LIST_METHOD_CHANGE;
      arrayOfTap[40] = PAYMENT_LIST_METHOD_EDIT;
      arrayOfTap[41] = PAYMENT_LIST_METHOD_SELECT;
      arrayOfTap[42] = PAYMENT_METHOD_ADD_CC_CANCEL;
      arrayOfTap[43] = PAYMENT_METHOD_ADD_CC_INTL;
      arrayOfTap[44] = PAYMENT_METHOD_ADD_PREPAID_WALLET;
      arrayOfTap[45] = PAYMENT_METHOD_DELETE_CANCEL;
      arrayOfTap[46] = PAYMENT_METHOD_DELETE_CONFIRM;
      arrayOfTap[47] = PAYMENT_METHOD_DETAIL_CLOSE;
      arrayOfTap[48] = PAYMENT_METHOD_EDIT_CC_CANCEL;
      arrayOfTap[49] = PAYMENT_METHOD_EDIT_CC_SAVE;
      arrayOfTap[50] = PAYMENT_METHOD_EDIT_CC_START;
      arrayOfTap[51] = PAYMENT_METHOD_LINK_PAYTM_ACCEPT;
      arrayOfTap[52] = PAYMENT_METHOD_LINK_PAYTM_CANCEL;
      arrayOfTap[53] = PRODUCTDETAIL_DISMISS_MAP;
      arrayOfTap[54] = PRODUCT_REQUEST;
      arrayOfTap[55] = PRODUCT_SELECT_CHILD;
      arrayOfTap[56] = PRODUCT_SELECT_PARENT;
      arrayOfTap[57] = PROMO_CODE_CANCEL;
      arrayOfTap[58] = PROMO_CODE_OPEN_CONFIRM;
      arrayOfTap[59] = PROMO_CODE_OPEN_MENU;
      arrayOfTap[60] = PROMO_CODE_OPEN_PAYMENT_LIST;
      arrayOfTap[61] = PROMO_CODE_SUBMIT;
      arrayOfTap[62] = REGISTER;
      arrayOfTap[63] = SEARCH_DROPOFF_CANCEL;
      arrayOfTap[64] = SEARCH_DROPOFF_OPEN_ADDFAVORITE;
      arrayOfTap[65] = SEARCH_DROPOFF_OPEN_EDITFAVORITE;
      arrayOfTap[66] = SEARCH_DROPOFF_OPEN_FARE_ESTIMATE;
      arrayOfTap[67] = SEARCH_DROPOFF_OPEN_MAP;
      arrayOfTap[68] = SEARCH_DROPOFF_OPEN_PRODUCTDETAIL;
      arrayOfTap[69] = SEARCH_DROPOFF_OPEN_PRODUCTDETAIL_BUTTON;
      arrayOfTap[70] = SEARCH_DROPOFF_SELECT;
      arrayOfTap[71] = SEARCH_MANUAL_SEARCH_KEYBOARD;
      arrayOfTap[72] = SEARCH_MANUAL_SEARCH_PAGE;
      arrayOfTap[73] = SEARCH_PICKUP_CANCEL;
      arrayOfTap[74] = SEARCH_PICKUP_OPEN_ADDFAVORITE;
      arrayOfTap[75] = SEARCH_PICKUP_OPEN_EDITFAVORITE;
      arrayOfTap[76] = SEARCH_PICKUP_OPEN_MAP;
      arrayOfTap[77] = SEARCH_PICKUP_OPEN_PRODUCTDETAIL;
      arrayOfTap[78] = SEARCH_PICKUP_SELECT;
      arrayOfTap[79] = SET_PICKUP_LOCATION_PIN;
      arrayOfTap[80] = SHARE_ETA_CANCEL;
      arrayOfTap[81] = SHARE_ETA_OPEN;
      arrayOfTap[82] = SHARE_ETA_SEND;
      arrayOfTap[83] = SHARE_ETA_SKIP_DESTINATION;
      arrayOfTap[84] = SIGN_UP_COUNTRY;
      arrayOfTap[85] = SIGN_UP_ENTER_NEXT;
      arrayOfTap[86] = SIGN_UP_FACEBOOK;
      arrayOfTap[87] = SIGN_UP_GOOGLE_PLUS;
      arrayOfTap[88] = SIGN_UP_NEXT;
      arrayOfTap[89] = SIGN_UP_PAYMENT_BUTTON_ALIPAY;
      arrayOfTap[90] = SIGN_UP_PAYMENT_BUTTON_COUNTRY;
      arrayOfTap[91] = SIGN_UP_PAYMENT_BUTTON_PAYPAL;
      arrayOfTap[92] = SIGN_UP_PAYMENT_CARDIO_START;
      arrayOfTap[93] = SIGN_UP_PAYMENT_GOOGLE_WALLET;
      arrayOfTap[94] = SIGN_UP_PAYMENT_LEGAL;
      arrayOfTap[95] = SIGN_UP_PAYMENT_PROMO;
      arrayOfTap[96] = SIGN_UP_PAYMENT_PROMO_APPLIED;
      arrayOfTap[97] = SURGE_DROP_NOTIFY;
      arrayOfTap[98] = SURGE_PRICING_ACCEPT;
      arrayOfTap[99] = SURGE_PRICING_CLOSE;
      arrayOfTap[100] = SURGE_SOBRIETY_CHECK_SUBMIT;
      arrayOfTap[101] = SURGE_TIMEOUT;
      arrayOfTap[102] = TRIP_CANCEL;
      arrayOfTap[103] = TRIP_CANCEL_CONFIRMATION_CANCEL;
      arrayOfTap[104] = TRIP_CANCEL_CONFIRMATION_CONFIRM;
      arrayOfTap[105] = WALLET_FUND_ADD_MONEY_ADD;
      arrayOfTap[106] = WALLET_FUND_ADD_MONEY_AMT_1;
      arrayOfTap[107] = WALLET_FUND_ADD_MONEY_AMT_2;
      arrayOfTap[108] = WALLET_FUND_ADD_MONEY_AMT_3;
      arrayOfTap[109] = WALLET_FUND_ADD_MONEY_BUTTON;
      arrayOfTap[110] = WALLET_FUND_ADD_MONEY_CANCEL;
      arrayOfTap[111] = WALLET_FUND_PROMO;
      arrayOfTap[112] = WALLET_FUND_X_OUT;
      arrayOfTap[113] = WALLET_LOW_BALANCE_ADD_MONEY;
      arrayOfTap[114] = WALLET_LOW_BALANCE_CANCEL;
      arrayOfTap[115] = WALLET_OTP_AUTH_RESEND;
      arrayOfTap[116] = WALLET_OTP_AUTH_VERIFY;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.metrics.analytics.RiderEvents
 * JD-Core Version:    0.6.2
 */