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
    box-shadow: 0 0 10px 5px #0001;
    background-color: rgba(255, 255, 255, 0.6);
}
</style>