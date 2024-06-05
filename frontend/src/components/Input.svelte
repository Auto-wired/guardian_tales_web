<script lang="ts">
let placeholder;
let type;

export { id, type, placeholder };
</script>

<input class="input" type={ type } placeholder={ placeholder }>

<style>
input {
    height: 32px;
    padding-left: 12px;
    border: 1px solid #000000;
    border-radius: 4px;
    outline: none;
    transition: focus .5s;
    font-size: 14px;
}

input::placeholder {
    font-size: 14px;
    color: #000000;
}
</style>