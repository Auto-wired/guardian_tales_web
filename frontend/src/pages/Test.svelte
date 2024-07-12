<script lang="ts">
import { onMount } from "svelte";
import axios from "axios";

type Test = {
    id: number,
    name: string,
    age: number,
    description: string,
};

let name: string;
let age: number;
let description: string;
let testList: Array<Test> = [];

async function getTestList (): Promise<void> {
    const { data } = await axios.get("http://localhost:8000/test/get/list");

    testList = data;
}

async function send (): Promise<void> {
    const { status } = await axios.post("http://localhost:8000/test/add", {
        name: name,
        age: age,
        description: description,
    });

    if (status === 200) {
        getTestList();
    } else {
        alert("error");
    }
}

onMount(() => {
    // getTestList();
});
</script>

<div id="container">
    <div class="input-container">
        <p>name</p>
        <input bind:value={ name } type="text">
    </div>
    <div class="input-container">
        <p>age</p>
        <input bind:value={ age } type="text">
    </div>
    <div class="input-container">
        <p>description</p>
        <input bind:value={ description } type="text">
    </div>
    <button on:click={ send }>send</button>
</div>

<br>

<div id="container">
    <div class="test-info-container">
        { #each testList as test }
            <p>id: { test.id }</p>
            <p>name: { test.name }</p>
            <p>age: { test.age }</p>
            <p>description { test.description }</p>
            <br>
        {/each }
    </div>
</div>

<style>
#container {
    width: 300px;
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.input-container {
    display: flex;
    justify-content: space-between;
}
</style>