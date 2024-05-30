<script lang="ts">
    import { Router, Route, Link } from "svelte-routing";

    import Main from "./pages/main/Main.svelte";
    import Login from "./pages/login/Login.svelte";
    import Register from "./pages/register/Register.svelte";
</script>

<Router url="">
    <Route path="/" component={ Main }></Route>
    <Route path="/login" component={ Login }></Route>
    <Route path="/register" component={ Register }></Route>
</Router>