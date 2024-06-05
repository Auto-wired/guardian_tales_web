<script lang="ts">
import { Link } from "svelte-routing";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import usernameIcon from "@images/icon/username.png";
import passwordIcon from "@images/icon/password.png";
</script>

<div id="register">
    <h1 class="title">REGISTER</h1>
    <div id="register-container">
        <TranslucenceContainer>
            <div id="id-container">
                <div class="input-title">
                    <img src={ usernameIcon } alt="username_icon">
                    <p>Username</p>
                </div>
                <Input type="text" placeholder="Username"></Input>
            </div>
            <div id="password-container">
                <div class="input-title">
                    <img src={ passwordIcon } alt="password_icon">
                    <p>Password</p>
                </div>
                <Input type="password" placeholder="Password"></Input>
            </div>
            <div id="confirm-password-container">
                <div class="input-title">
                    <img src={ passwordIcon } alt="password_icon">
                    <p>Confirm Password</p>
                </div>
                <Input type="password" placeholder="Password"></Input>
            </div>
            <Button>Register</Button>
            <div id="link-container">
                <Link to="/login" class="link">Already have an account?</Link>
            </div>
        </TranslucenceContainer>
    </div>
</div>

<style>
#register {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background: url("@images/background/background.png");
    background-size: cover;
    background-position: center;
}

.title {
    margin-bottom: 24px;
    font-size: 44px;
    text-align: center;
    text-shadow: -1px 0px #ffffff, 0px 1px #ffffff, 1px 0px #ffffff, 0px -1px #ffffff;
}

#password-container, #confirm-password-container {
    margin-top: 24px;
}

:global(#register .input) {
    width: 300px;
}

:global(#register .input:placeholder-shown) {
    transition: background-color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#register .input, #register .input:hover, #register .input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

.input-title {
    margin-bottom: 8px;
    display: flex;
    align-items: center;
}

.input-title > img {
    width: 24px;
    height: 24px;
    margin-right: 8px;
}

.input-title > p, :global(#register .button) {
    font-weight: bold;
}

:global(#register .button) {
    width: 300px;
    margin-top: 24px;
    transition: background-color .5s, color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#register .button:hover) {
    color: #ffffff;
    background-color: #000000;
}

#link-container {
    margin-top: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
}

:global(#register .link) {
    font-size: 14px;
    font-weight: bold;
    transition: text-shadow .5s;
    color: #000000;
}

:global(#register .link:hover) {
    text-shadow: -1px 0px #ffffff, 0px 1px #ffffff, 1px 0px #ffffff, 0px -1px #ffffff;
}
</style>