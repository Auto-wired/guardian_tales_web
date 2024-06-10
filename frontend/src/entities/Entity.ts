export default class Entity {

    protected validateLength (target: string, minLength: number, maxLength: number): boolean {
        return target.length < minLength || target.length > maxLength;
    }

}