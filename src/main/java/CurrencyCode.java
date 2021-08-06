public class CurrencyCode {
    private String numericCode;
    private String alphaCode;


    public CurrencyCode(String numericCode) {
        this.numericCode = numericCode;
        DetermineAlphaCode();
    }
    private void DetermineAlphaCode() {
        switch (numericCode) {
            case "840":
                alphaCode = "usd";
                break;
            case "978":
                alphaCode = "eur";
                break;
            case "826":
                alphaCode = "gbp";
                break;
            case "643":
                alphaCode = "rub";
                break;
            default:
                throw new Error("Invalid Currency Code!");
        }
    }

    public String GetNumericCode() {
        return numericCode;
    }

    public String GetAlphaCode() {
            return alphaCode;
    }
}
