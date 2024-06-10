<script lang="ts">
import { Router, Route, Link } from "svelte-routing";

import Main from "./pages/main/Main.svelte";
import Login from "./pages/login/Login.svelte";
import Register from "./pages/register/Register.svelte";
import ForgotAccount from "./pages/forgot_account/ForgotAccount.svelte";
import NotFound from "./pages/NotFound.svelte";
</script>

<Router>
    <Route path="/" component={ Main }></Route>
    <Route path="/login" component={ Login }></Route>
    <Route path="/register" component={ Register }></Route>
    <Route path="/forgot-account" component={ ForgotAccount }></Route>
    <Route path="*" component={ NotFound }></Route>
</Router>