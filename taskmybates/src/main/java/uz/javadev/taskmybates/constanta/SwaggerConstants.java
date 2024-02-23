package uz.javadev.taskmybates.constanta;

public class SwaggerConstants {

    public static final String CREATE_USER_EXAMPLE = """
            {
                "firstName": "Anvar",
                "lastName": "Sanayev",
                "address": "Tashkent"
            }
            """;

    public static final String CREATE_USER_RESPONSE_SUCCESS_EXAMPLE = """
            {
              "message": "Muvoffaqiyatli Saqlandi!"
            }
            """;

    public static final String CREATE_USER_RESPONSE_INTERNAL_ERROR_EXAMPLE = """
            {
              "message": "User saqlash jarayonida xatolik!"
            }
            """;
}
