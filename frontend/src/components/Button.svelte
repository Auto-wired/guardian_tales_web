<script lang="ts">
let event: Function;

export { event };
</script>

<button class="button" on:click={ () => event() }>
    <slot></slot>
</button>

<style>
button {
    height: 32px;
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px solid #000000;
    border-radius: 4px;
    outline: none;
    cursor: pointer;
}
</style>