# Razorpay-Java-Client

### About razorpay java client
This is razorpay payment integration with Java client.
This repo covers the easiest steps to integration of Razorpay in backend Java and front-end(Angular or React).

Reference API link:- [Razorpay link](https://docs.razorpay.com/docs).

**Strongly recommended to lean hosted checkout flow form for below link**
- [Click here](https://razorpay.com/docs/payment-gateway/web-integration/hosted/)

**To integrate your razorpay account follow below steps**

- Copy your key_id and secert from Razorpay Dashboard.
   - Login to razorpay -> Settings -> API Keys
- Clone this repo (if not clone)
- Replace your razorpay key and secret in com.razorpay.client.razorpay.CustomRazopayClient

**_Below steps are the test account. User of that will not charge from their bank and below is used for testing purpose only._**

### Step 1 - Create order via API
- Here we will create an order via hosted API.
- UI - can call this API on click of user amount selection or order create.

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
- Use below UI form that call hosted checkout form of razorpay.
#### Request
```
<html>
    <form method="POST" action="https://api.razorpay.com/v1/checkout/embedded">
    <input type="hidden" name="key_id" value="<secret-key-id>" />
    <input type="hidden" name="amount" value="<amount>">
    <input type="hidden" name="order_id" value="<razorpay-order-id>">
    <input type="hidden" name="prefill[name]" value="<person name>">
    <input type="hidden" name="prefill[contact]" value="<person contact number>">
    <input type="hidden" name="prefill[email]" value="<person email id>">
    <input type="hidden" name="callback_url" value="https://glacial-earth-89199.herokuapp.com/callback_url">
    <button>Submit</button>
    </form>
</html>
```
`<razorpay-order-id>` -> would be the id from step 1.
`<amount>` -> would be the same.

#### Resonse
````
{
	status: true,
	description: "Success",
	responseObejct: [{
		id: 13,
		razorpayOrderId: "order_D4hRIFmezNT1Kw",
		razorpayPaymentId: "pay_D4hRl7pv5zhIpH",
		status: "CALLBACK_CALL",
		razorpayStatus: "Attempted",
		created_at: "2019-08-11T17:01:05.000+0000",
		amount: 10000
	}]
}
````
Note:- Copy `razorpayPaymentId` will use in next step.

### Step 3 - Capture payment via backend API

- This is the last steps that ensure capture payment and tell razorpay successful enrollment.
- Use below Test API for capture api.
#### Request
````
Request URL :- https://glacial-earth-89199.herokuapp.com/payment/capture_payment/<payment-id>
Header :- Content-Type:application/json
````
#### Response
````
{
    "status": true,
    "description": "capture payment status",
    "responseObejct": "success"
}
````
`<payment-id>` -> would be the payment id which you get from step 2.

#### Note:- I would strongly recommended to use Angular 6 or greater or react UI technology. UI person has knowledge of rest api call and handle multiple call-back.

