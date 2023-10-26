package Utils;

public class TestDataUtils {
    public static String getOKPO(String country, String typeOfOwnership) {
        final String countryRu = "ru";
        final String ownerIP = "ИП";
        if (country.equals(countryRu) & typeOfOwnership.equals(ownerIP)) {
            return JsonUtils.getValue("testData.json","okpo_10");
        } else {
            return JsonUtils.getValue("testData.json","okpo_8");
        }
    }
    public static String getINN(String country) {
        final String countryKg = "kg";
        if (country.equals(countryKg)) {
            return JsonUtils.getValue("testData.json","inn_kg");
        } else {
            return JsonUtils.getValue("testData.json","inn");
        }
    }
}
