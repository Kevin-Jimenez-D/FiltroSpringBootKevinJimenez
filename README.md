# **Filter SpringBoot 👀**

## Main objective
Build a REST API in Java for an application that allows managing a control and rating system for audiovisual content consumed by a user

## Technologies Used
The project will utilize the following technologies in Backend:
- Java 
- Spring Boot framework
- MySQL  database
- Spring Data JPA
- Cors
- JWT
- Swagger
- JPQL

## Database Design
![Database Design](/src/main/resources/imagesDocumentation/DataBaseImage.png)

### The file is FilterSpring.sql in Resources

<details>
   <summary>FilterSpring.sql</summary>

   1. Queries

   ```sql
    DROP DATABASE IF EXISTS filtro;
    CREATE DATABASE filtro;
    USE filtro; 

    CREATE TABLE type_of_content(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL
    );

    CREATE TABLE StateVisualization(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        stateVisualization VARCHAR(255) NOT NULL
    );

    CREATE TABLE Gender(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        gender VARCHAR(255) NOT NULL
    );

    CREATE TABLE Costumer(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        firstName VARCHAR(255) NOT NULL,
        secondName VARCHAR(255),
        firstLastName VARCHAR(255) NOT NULL,
        secondLastName VARCHAR(255)
    );

    CREATE TABLE Platform(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        typeOfContent_ID BIGINT NOT NULL,
        FOREIGN KEY(typeOfContent_ID) REFERENCES type_of_content(id)
    );

    CREATE TABLE AudioVisual(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        platform_ID BIGINT NOT NULL,
        gender_ID BIGINT NOT NULL,
        stateVisualization_ID BIGINT NOT NULL,
        FOREIGN KEY(platform_ID) REFERENCES Platform(id),
        FOREIGN KEY(gender_ID) REFERENCES Gender(id),
        FOREIGN KEY(stateVisualization_ID) REFERENCES StateVisualization(id)
    );

    CREATE TABLE CostumerAudioVisual(
        costumer_ID BIGINT NOT NULL,
        audioVisual_ID BIGINT NOT NULL,
        PRIMARY KEY(costumer_ID, audioVisual_ID),
        FOREIGN KEY(costumer_ID) REFERENCES Costumer(id),
        FOREIGN KEY(audioVisual_ID) REFERENCES AudioVisual(id)
    );

    CREATE TABLE Register(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        qualification DOUBLE NOT NULL,
        comment VARCHAR(255) NOT NULL,
        audioVisual_ID BIGINT NOT NULL,
        FOREIGN KEY(audioVisual_ID) REFERENCES AudioVisual(id)
    );
   ```

</details>

### Remember to change user and password if you are going to see the API in Campus, and to work with Swagger

![ApplicationPropierties](/src/main/resources/imagesDocumentation/AplicationPropierties.png)

## Folder organization

![Folder Organization](/src/main/resources/imagesDocumentation/FolderOrganization.png)

## Security

### Register

- First, you need to register with the next url:

   ```
   localhost:8080/register
   ```

In queries, you add the parameteters ```user``` and ```encryptedPass``` with data.

![Register and create the Web Token](/src/main/resources/imagesDocumentation/RegisterSecurity.png)

### Login

- With the same data in ```user``` and ```encryptedPass```, you can login in the next url:

   ```
   localhost:8080/login
   ```

The next step is copy the ```token```, with data, you can access to the api

![Login and create the Web Token](/src/main/resources/imagesDocumentation/LoginSecurity.png)

### Access with Token

- In headers, you add ```Authorization``` and paste the token, so you will have access to the methods https

![Get Data with Web Token](/src/main/resources/imagesDocumentation/GetTypeOfData.png)

## Swagger

- Enter with the next URL

   ```
   http://localhost:8080/doc/swagger-ui/index.html
   ```

- Configure the Swagger with the correct route

![Configure the Swagger](/src/main/resources/imagesDocumentation/ConfigSwagger.png)

- Authorize Swagger With the Web Token

![Authorize Swagger with Web Token](/src/main/resources/imagesDocumentation/AuthorizeSwagger.png)

- And you can see the endpoints with Swagger

![Swagger view](/src/main/resources/imagesDocumentation/SwaggerView.png)

# API endpoints

## With Insomnia

These endpoints allow you to handle Stripe subscriptions for Publish and Analyze.

## GET
`GetTypeOfContent` [localhost:8080/typeOfContent](#get-1billingretrieve-billing-datajson) 

`GetTypeOfContentByName` [localhost:8080/typeOfContent/serie](#get-1billingretrieve-billing-datajson) 

`GetGender` [localhost:8080/genders](#get-1billingretrieve-billing-datajson) 

`GetStateVisualizationAll` [localhost:8080/stateVisualizations](#get-1billingretrieve-billing-datajson)

`GetStateVisualizationById` [localhost:8080/stateVisualizations/5](#get-1billingretrieve-billing-datajson)

`GetAllCostumer` [localhost:8080/costumers](#get-1billingretrieve-billing-datajson)

`GetCostumerById` [localhost:8080/costumers/1](#get-1billingretrieve-billing-datajson)

`GetAllPlatforms` [localhost:8080/platforms](#get-1billingretrieve-billing-datajson)
    <br/>

## POST
`Register` [localhost:8080/register](#post-1billingstart-trialjson) <br/>
`Login` [localhost:8080/login](#post-1billingcancel-trialjson) <br/>
`SaveTypeOfContent` [localhost:8080/typeOfContent/save](#post-1billingstart-or-update-subscriptionjson) <br/>
`SaveGener` [localhost:8080/genders/save](#post-1billingcancel-subscriptionjson) <br/>
`SaveStateVisualization` [localhost:8080/stateVisualizations/save](#post-1billingstart-trialjson) <br/>
`SaveCostumer` [localhost:8080/costumers/save](#post-1billingcancel-trialjson) <br/>
`SavePlatform` [localhost:8080/platforms/save](#post-1billingstart-or-update-subscriptionjson) <br/>
___

## PUT
`PutStateVisualizationById` [localhost:8080/stateVisualizations/5](#put-1billingstart-trialjson) <br/>
`PutCostumerById` [localhost:8080/costumers/1](#put-1billingcancel-trialjson) <br/>

## DELETE

`DeleteCostumerById` [localhost:8080/costumers/1](#put-1billingcancel-trialjson) <br/>

### GET /1/billing/retrieve-billing-data.json
Get basics billing data for the current user or for a given organization ID (as long as the current user is part of that organization). (it has been poorly implemented for now to unblock the Analyze team, and should only be used by Analyze) `official client only`

**Parameters**

|          Name | Required |  Type   | Description                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `product` | required | string  | The product for which to perform the action. <br/><br/> Supported values: `publish` or `analyze`.                                                                     |
|     `organization_id` | optional | string  | The organization ID for which to perform the action. <br/><br/> Default is `null`. <br/><br/> If passed, we will check if the user is part of that organization before returning any information.                                                                     |

**Response**

```
// Customer has no subscription
{
    "success": true,
    "data": {
        "subscriptions": []
    }
}

or

// Customer has one paying subscription
{
    "success": true,
    "data": {
        "subscriptions": [
            0 => [
                "plan_name": "early-access-10", //could be any supported plan
                "quantity": 11,
                "cycle": "month|year",
                "current_period_end": 1531897966, //timestamp in seconds
                "cancel_at_period_end": true|false,
                is_paying: true,
                is_trialing: false
            ]
        ]
    }
}

or

// Customer has one trialing subscription
{
    "success": true,
    "data": {
        "subscriptions": [
            0 => [
                "plan_name": "early-access-10", //could be any supported plan
                "quantity": 11,
                "cycle": "month|year",
                "current_period_end": 1531897966, //timestamp in seconds
                "cancel_at_period_end": true|false,
                is_paying: false,
                is_trialing: true
            ]
        ]
    }
}

or

// Customer has two subscriptions
{
    "success": true,
    "data": {
        "subscriptions": [
            0 => [
                "plan_name": "pro", //could be any supported plan
                "quantity": 1,
                "cycle": "month|year",
                "current_period_end": 1531897966, //timestamp in seconds
                "cancel_at_period_end": true|false,
                is_paying: true,
                is_trialing: false
            ],
            1 => [
                "plan_name": "business", //could be any supported plan
                "quantity": 1,
                "cycle": "month|year",
                "current_period_end": 1531897966, //timestamp in seconds
                "cancel_at_period_end": true|false,
                is_paying: false,
                is_trialing: true
            ]
        ]
    }
}


or any implemented error from https://buffer.com/developers/api/errors

{
    "code": 1000,
    "error": "An error message"
}
```
___

### POST /1/billing/start-trial.json
Starts a trial for a user. `official client only`

**Parameters**

|          Name | Required |  Type   | Description                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `product` | required | string  | The product for which to perform the action. <br/><br/> Supported values: `publish` or `analyze`.                                                                     |
|        `plan` | required | string  | The plan for which to start the trial period. <br/><br/> Supported values for Publish: `pro`, `small`, `business`, `agency`.  <br/>Supported values for Analyze: `early-access-10`, `early-access-25`, `early-access-50`, `early-access-100`. |
| `trialLength` | optional | integer | Length of the trial in days. <br/><br/>Default is `null`. <br/><br/>If value is null, relies on the product hook logic to define the trial length for the given plan and product.                    |
|       `cycle` | optional | string  | Default is `null`. <br/><br/>If value is null, relies on the product hook logic to define the cycle. <br/><br/> Supported values: `null`, `month` or `year`          |
|    `quantity` | optional | integer  | Default is `1`. <br/><br/>This value (either default or passed) will always override the current subscription quantity value.          |
|    `cta` | optional | string  | Can be used for tracking purpose - [Read more](https://github.com/bufferapp/README/tree/master/runbooks/data-tracking)          |

**Response**

```
{
    "success": true
}

or any implemented error from https://buffer.com/developers/api/errors

{
    "code": 1000,
    "error": "An error message"
}
```
___

### POST /1/billing/cancel-trial.json
Cancels a trial for a user. `official client only`

**Parameters**

|          Name | Required |  Type   | Description                                                                                                                                                         |
| -------------:|:--------:|:-------:| ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `product` | required | string  | The product for which to perform the action. <br/><br/> Supported values: `publish` or `analyze`.                                                                   |
|    `cta` | optional | string  | Can be used for tracking purpose - [Read more](https://github.com/bufferapp/README/tree/master/runbooks/data-tracking)          |

**Response**

```
{
    "success": true
}

or any implemented error from https://buffer.com/developers/api/errors

{
    "code": 1000,
    "error": "An error message"
}
```
___

### POST /1/billing/start-or-update-subscription.json
Starts a new subscription or updates an existing one. Can (and should) also be used to complete a trial period. `official client only`

**Parameters**

|          Name | Required |   Type  | Description                                                                                                                                                         |
| -------------:|:--------:|:-------:| ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `product` | required | string  | The product for which to perform the action. <br/><br/> Supported values: `publish` or `analyze`.                                                                   |
|        `plan` | required | string  | The plan for which to start a subscription. <br/><br/> Supported values for Publish: `pro`, `small`, `business`, `agency`.  <br/>Supported values for Analyze: `early-access-10`, `early-access-25`, `early-access-50`, `early-access-100`. |
| `stripeToken` | optional | string | Is `required` only the first time when the Stripe customer has no registered credit card. <br/><br/>Stripe tokens are usually generated on the frontend: see [Stripe doc](https://stripe.com/docs/stripe-js/elements/quickstart#create-token) and as an example [Add credit card form Buffer component](https://github.com/bufferapp/buffer-web/blob/master/app/webroot/js/creditCard/components/addCreditCardForm.jsx).<br/><br/>*Stripe will error if we start/update a subscription for a customer who has no credit card: only trials can be started without a credit card.*  <br/> *Please use [/1/billing/start-trial.json](#post-1billingstart-trialjson) to start a trial.*|
|       `cycle` | optional | string | Default is `null`. <br/><br/>If value is null, relies on the product hook logic to define the cycle. <br/><br/> Support values: `null`, `month` or `year`          |
|    `quantity` | optional | integer  | Default is `1`.  <br/><br/>This value (either default or passed) will always override the current subscription quantity value.         |
|    `cta` | optional | string  | Can be used for tracking purpose - [Read more](https://github.com/bufferapp/README/tree/master/runbooks/data-tracking)          |

**Response**

```
{
    "success": true
}

or any implemented error from https://buffer.com/developers/api/errors

{
    "code": 1000,
    "error": "An error message"
}
```
___

### POST /1/billing/cancel-subscription.json
Cancels an existing subscription. Will cancel any existing and trialing subscriptions. `official client only`

**Parameters**

|          Name | Required |  Type   | Description                                                                                                                                                         |
| -------------:|:--------:|:-------:| ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `product` | required | string  | The product for which to perform the action. <br/><br/> Supported values: `publish` or `analyze`.                                                                   |
| `atPeriodEnd` | optional | boolean | Default is `true`. Specifies if the subscription should be deleted now or when the subscription is due to end. <br/><br/> *Common use case is to pass `true` since we want to let the customers use the full period they paid for.* <br/>*Should only pass `false` (i.e. cancel the subscription right now) when a Stripe customer switches to iOS/Android.)* |
|    `cta` | optional | string  | Can be used for tracking purpose - [Read more](https://github.com/bufferapp/README/tree/master/runbooks/data-tracking)          |

**Response**

```
{
    "success": true
}

or any implemented error from https://buffer.com/developers/api/errors

{
    "code": 1000,
    "error": "An error message"
}
```