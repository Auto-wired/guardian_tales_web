<script lang="ts">
import { Link } from "svelte-routing";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";
</script>

<div id="forgot-account">
    <h1 class="title">FORGOT ACCOUNT</h1>
    <div id="forgot-account-container">
        <TranslucenceContainer>
            <p>id</p>
            <p>password</p>
        </TranslucenceContainer>
    </div>
</div>

<style>
#forgot-account {
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
</style>