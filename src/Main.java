public class Main {
    public static void main(String[] args) {
        int id = 0;
        EmployeeBook company = new EmployeeBook(10);
        company.addNewEmployee("Джонсон Олег Владимирович", 2, 100_000, id++);
        company.addNewEmployee("Соловьев Игорь Сергеевич", 3, 120_000, id++);
        company.addNewEmployee("Петров Валентин Михайлович", 1, 150_000, id++);
        company.addNewEmployee("Иванов Сергей Геннадьевич", 5, 90_000, id++);
        company.addNewEmployee("Соколова Наталья Семёновна", 4, 130_000, id++);
        company.addNewEmployee("Киркоров Матвей Савельевич", 2, 200_000, id++);
        company.addNewEmployee("Апаткин Владислав Андреевич", 4, 115_000, id++);
        company.addNewEmployee("Меркель Зиноида Ивановна", 3, 137_000, id++);
        company.addNewEmployee("Пушкин Анатолий Дмитриевич", 1, 180_000, id++);
        company.addNewEmployee("Фёдоров Андрей Валерьевич", 5, 250_000, id++);
        company.printAllEmployees();
    }
}