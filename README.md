# Acquired Android Library

## Requirements

- Android 6.0+
- Android SDK 23 or later

## HPP Library Installation

### Gradle users
Add this dependency to your project's build file:
```
implementation 'com.github.AcquiredSupport:Acquired-SDK-Android:v1.0.0'
```

### Manual

You can integrate the Acquired Android Library into your project manually.

- Download the latest release from GitHub:

    https://github.com/AcquiredSupport/Acquired-SDK-Android/releases

- Add module 'acquired-sdk' into your project to use the HPP Library.

## Using the HPP Library

### Initiation

To initiate an instance of the HPP payment form do the following:

```
HPPSetting hppSetting = new HPPSetting(211, 1229, "hashcode");
hppSetting.setIsDebug(true);
hppSetting.setOrderId(generateOrderId());
hppSetting.setTransactionType("AUTH_ONLY");
hppSetting.setCurrencyCode("GBP");
hppSetting.setAmount(Float.valueOf("100.1"));
hppSetting.setErrorUrl("https://www.yourwebsite.com/error");

HPPManager.init(view.getContext(), hppSetting);
```

### Integrate With Your Server

The HPPManager requires some HPP settings which you can get it on acquired dashboard (server side).

1) **Company ID**: Utilising one of the Acquired HPP server SDKs; company_id is necessary to create an instance of HppSetting which is required for HPPManager.

2) **Company MID ID**: Using this value the SDK will choose the default template that has been uploaded through the Acquired Dashboard.

3) **Hash Code**: This parameter is used to encode the requests of HPP, a new hash will be generated, server side will check the validity of the hash and decode the response.

```
HPPSetting hppSetting = new HPPSetting(211, 1229, "hashcode");
```


### Present Payment Form

Insert the code fragment into your activity to present a payment form as follows:

```
    HPPManager.init(view.getContext(), hppSetting);
```

Executing this code, HPP Manager will process the given parameters (HppSetting), get the request from the server, send the encoded request to HPP and present the form received back.

###  HPP Response 

On the server-side you can set your own return url or call back url, hpp will handle response automatically that you don't have to do any response handling on your app. You can also set another return url or call back url when calling HPPManager in your app:

```
hppSetting.setReturnUrl("xxxx");
hppSetting.setCallBackUrl("xxxx");
```

## FAQ

### Set HPP Properties
HppSetting is used to provide all parameters that server requires:card detail, shipping address, billing address..., etc. 
You can also set whatever HPP properties you need to in the component, for example;

```
hppSetting.setIsDebug(true);
hppSetting.setOrderId(generateOrderId());
hppSetting.setCurrencyCode("GBP");
hppSetting.setAmount(Float.valueOf("100.1"));
hppSetting.setBillingEmail("xxx@acquired.com");
...
```

These will be sent to the *Request Producer URL*, your server-side code must be setup to take in these values and pass them to the HPP server-side SDK for them to be included in the request.  

### Testing     

Acquired maintains separate endpoints for live and test transactions. Use the code below:

```
hppSetting.setIsDebug(true);
```     

## License

See the LICENSE file.
