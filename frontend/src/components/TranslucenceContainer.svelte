<script lang="ts"></script>

<div class="translucence-container">
    <slot></slot>
</div>

<style>
.translucence-container {
    width: 100%;
    height: 100%;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 20px 5px #000000;
    background-color: rgba(255, 255, 255, 0.6);
}
</style>