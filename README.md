# Razorpay-Java-Client

### About razorpay java client
This is razorpay payment integration with Java client.
This repo covers the easiest steps for integration of Razorpay in backend Java and front-end(Angular or React).

Reference link:- [Razorpay link](https://docs.razorpay.com/docs).

**Strongly recommended to under hosted checkout form for below link
- [Click here](https://razorpay.com/docs/payment-gateway/web-integration/hosted/)

**To integrate your razorpay account follow below steps**

- Copy your key_id and secert from Razorpay Dashboard.
   - Login to razorpay -> Settings -> API Keys
- Clone this repo (if not clone)
- Replace your razorpay key and secret in com.razorpay.client.razorpay.CustomRazopayClient

*Below steps are the test account. User of that will not charge from their bank and below is used for testing purpose only.*

### Step 1 - Create order via API
- Here we will create an order
#### Request
```
Request URL :- https://glacial-earth-89199.herokuapp.com/payment/order_create
Method :- POST
Headers :- Content-Type:application/json
Body :-
{
   "amount":100
}
```

#### Response
```
{
    "status": true,
    "description": "Order has been created.",
    "responseObejct": {
        "id": 13,
        "razorpayOrderId": "order_D4hRIFmezNT1Kw",
        "status": "ORDER_CREATE",
        "razorpayStatus": "created",
        "created_at": "2019-08-11T17:01:05.000+0000",
        "amount": 10000
    }
}
```
Note:- Copy or make note of `razorpayOrderId` and `amount` will use in next step.


### Step 2 - Razorpay checkout form with amount and order id


### Step 3 - Capture payment via backend API