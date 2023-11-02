package org.university.lab9;

public class Main {
    public static void main(String[] args) {
        DataEndpoint[] dataEndpoints = {
                new DataEndpoint("/countries", "countries", "countries", ""),
                new DataEndpoint("/cities", "cities", "cities", ""),
                new DataEndpoint("/districts", "districts", "kyiv_districts", "&city_id=216"),
                new DataEndpoint("/street/allstreets", "streets", "all_streets", ""),
                new DataEndpoint("/street/streets", "streets", "kyiv_streets", "&city_id=216"),
                new DataEndpoint("/metro/stations", "metro_stations", "kyiv_metro_stations", "&city_id=216"),
                new DataEndpoint("/routes/bycity", "routes", "kyiv_routes", "&city_id=216"),
                new DataEndpoint("/estatetypes/groups", "groups", "groups", ""),
                new DataEndpoint("/estatetypes", "types", "kyiv_types", "group_id=216"),
                new DataEndpoint("/finish/all", "finishes", "finishes", ""),
                new DataEndpoint("/dictionary/values", "values", "cond", "&type=5"),
                new DataEndpoint("/dictionary/values", "values", "water", "&type=12"),
                new DataEndpoint("/dictionary/values", "values", "gas", "&type=14"),
                new DataEndpoint("/dictionary/values", "values", "electro", "&type=10"),
                new DataEndpoint("/dictionary/values", "values", "canal", "&type=11"),
                new DataEndpoint("/estate/search", "results", "estate", "&id=city_title=Киев&min_price_meter=224&max_price_meter=250"),
                new DataEndpoint("/estate/searchlastedited", "results", "changed_estate", "&id=city_title=Киев&min_price_meter=224&max_price_meter=250"),
                new DataEndpoint("/agent/all", "agents", "agents", ""),
                new DataEndpoint("/picture/EstateCoverPhoto", "pictures", "estate_cover_picture", "&estate_id=21&width=640&height=480&crop=1&watermark=0"),
                new DataEndpoint("/picture/EstatePhoto", "pictures", "estate_pictures", "&estate_id=21&width=640&height=480&crop=1&watermark=0"),
                new DataEndpoint("/picture/EstateLayout", "pictures", "layout_pictures", "&estate_id=21&width=640&height=480&crop=1&watermark=0"),
                new DataEndpoint("/picture/BuildingPhoto", "pictures", "building_pictures", "&building_id=5&width=640&height=480&crop=1&watermark=0"),
                new DataEndpoint("/contragent/getall", "contragents", "contragents", "&agent_id=13&type=2&name=Юлия"),

        };

        for (DataEndpoint endpoint : dataEndpoints) {
            String jsonResponse = callApiAndHandleExceptions(endpoint.getEndpoint(), endpoint.getArguments());
            convertJsonToExcelAndHandleExceptions(jsonResponse, "sheet", endpoint.getKey(), endpoint.getSheetName());
        }
    }

    private static String callApiAndHandleExceptions(String endpoint, String arguments) {
        try {
            String jsonResponse = ApiService.callApi(endpoint, arguments);
            System.out.println(jsonResponse);
            return jsonResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void convertJsonToExcelAndHandleExceptions(String jsonResponse, String filename, String dataArrayKey, String sheetName) {
        if (jsonResponse != null) {
            try {
                JsonExcelConverter.Convert(jsonResponse, filename, dataArrayKey, sheetName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
