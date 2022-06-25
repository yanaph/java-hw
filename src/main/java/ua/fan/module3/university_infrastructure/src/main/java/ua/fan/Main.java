package ua.fan;

import ua.fan.service.UniversityQueryService;

public class Main {
    public static void main(String[] args) {
        UniversityQueryService universityQueryService = new UniversityQueryService();
        universityQueryService.init();
    }
}
