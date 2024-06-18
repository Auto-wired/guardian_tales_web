export default class Lupina {

    element: HTMLImageElement;
    speed: number;
    directionX: number;
    directionY: number;

    constructor (element: HTMLImageElement, speed: number, directionX: number, directionY: number) {
        this.element = element;
        this.speed = speed;
        this.directionX = directionX;
        this.directionY = directionY;
    }

}