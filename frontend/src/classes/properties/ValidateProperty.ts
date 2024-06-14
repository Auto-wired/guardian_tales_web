export default class ValidateProperty {
    
    public validateResult: string;
    public input: HTMLInputElement;

    constructor (validateResult: string, input: HTMLInputElement) {
        this.validateResult = validateResult;
        this.input = input;
    }

}