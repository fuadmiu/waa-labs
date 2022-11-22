# Lab 06 (Refresh Token)
## Mohammad Hizbullah Fuad (614629)
## Token Refresh procedures:
1. Server sends both Access Token and Refresh Token for all request.
2. The filter in the backend performs the following check.
    * if both the tokens are present in the header
        * if access token is expired and refresh token is still valid
            * extract username from refresh token and obtain **userdetails** using the username.
            * Generate new access token and refresh token
            * Set the user to the authentication context.
            * Attach both of the tokens to **response header**
            * In the client side, set up an interceptor to extract **accessToken** and **refreshToken** and send the updated tokens thereafter.
          

### This way, the client just needs to send both of the tokens in the header and intercept the response to check if there is any updated token sent by the server.

