package com.ubercab.client.feature.shoppingcart.network;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.otto.Bus;
import com.ubercab.client.feature.shoppingcart.event.InventoryResponseEvent;
import com.ubercab.client.feature.shoppingcart.model.Inventory;
import java.io.IOException;
import java.io.Reader;

public class InventoryClient
{
  private final Bus mBus;
  private final OkHttpClient mClient;
  private final Gson mGson;

  public InventoryClient(Bus paramBus, OkHttpClient paramOkHttpClient, Gson paramGson)
  {
    this.mBus = paramBus;
    this.mClient = paramOkHttpClient;
    this.mGson = paramGson;
  }

  public void getInventory(String paramString1, String paramString2)
  {
    Request localRequest = getRequestForUrl(paramString2);
    this.mClient.newCall(localRequest).enqueue(new InventoryCallback(paramString1));
  }

  Request getRequestForUrl(String paramString)
  {
    return new Request.Builder().url(paramString).build();
  }

  class InventoryCallback
    implements Callback
  {
    private String mVehicleViewId;

    InventoryCallback(String arg2)
    {
      Object localObject;
      this.mVehicleViewId = localObject;
    }

    void handleResponseReader(Reader paramReader)
    {
      postEventToBus(parseJsonToResponseEvent(paramReader));
    }

    public void onFailure(Request paramRequest, IOException paramIOException)
    {
      postEventToBus(new InventoryResponseEvent(this.mVehicleViewId, paramIOException));
    }

    public void onResponse(Response paramResponse)
    {
      handleResponseReader(paramResponse.body().charStream());
    }

    InventoryResponseEvent parseJsonToResponseEvent(Reader paramReader)
    {
      try
      {
        Inventory localInventory = (Inventory)InventoryClient.this.mGson.fromJson(paramReader, Inventory.class);
        InventoryResponseEvent localInventoryResponseEvent = new InventoryResponseEvent(this.mVehicleViewId, localInventory);
        return localInventoryResponseEvent;
      }
      catch (JsonSyntaxException localJsonSyntaxException)
      {
        return new InventoryResponseEvent(this.mVehicleViewId, localJsonSyntaxException);
      }
      catch (JsonIOException localJsonIOException)
      {
        label35: break label35;
      }
    }

    void postEventToBus(InventoryResponseEvent paramInventoryResponseEvent)
    {
      InventoryClient.this.mBus.post(paramInventoryResponseEvent);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.shoppingcart.network.InventoryClient
 * JD-Core Version:    0.6.2
 */