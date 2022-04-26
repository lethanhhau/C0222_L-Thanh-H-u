package hau.case_study_furama_resort.service.impl;

import hau.case_study_furama_resort.common.validate.ValidateFacility;
import hau.case_study_furama_resort.common.validate.ValidateHouse;
import hau.case_study_furama_resort.common.validate.ValidateRom;
import hau.case_study_furama_resort.common.validate.ValidateVila;
import hau.case_study_furama_resort.model.facility_model.Facility;
import hau.case_study_furama_resort.model.facility_model.House;
import hau.case_study_furama_resort.model.facility_model.Room;
import hau.case_study_furama_resort.model.facility_model.Vila;
import hau.case_study_furama_resort.service.IFacilityService;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    private Scanner scanner = new Scanner(System.in);
    private static Map<Facility, Integer> facilities = new LinkedHashMap<Facility, Integer>();
    private static List<Facility> maintenancefacilities = new ArrayList<>();


    {

        facilities.put(new House("SVHO-1234","house1", "200m", 600d, 6,
                "theo năm", "3*", 2), 1);
        facilities.put(new House("SVHO-3456","house2", "300m", 800d, 8,
                "theo năm", "3*", 2), 2);
        facilities.put(new Room("SVRO-8934","room", "100m", 200d, 2, "theo giờ",
                "bữa sáng"), 4);
        facilities.put(new Room("SVRO-0198","rom1", "120m", 300d, 2, "theo giờ",
                "ăn sáng"), 5);
        facilities.put(new Vila("SVVL-7932","villa", "600m", 1800d, 12, "theo tháng",
                "4*", 120d, 1), 5);
        facilities.put(new Vila("SVVL-9642","vila1", "800m", 2000d, 15, "theo tháng",
                "5*", 200d, 1), 6);
    }

    @Override
    public void display() {
        Set<Facility> facilitySet = facilities.keySet();
        for (Facility i : facilitySet) {
            System.out.println(i);
        }
    }

    @Override
    public void add(Facility facility) {
        Set<Facility> facilitySet = facilities.keySet();
        if (facilities.isEmpty()){
            facilities.put(facility,1);
        }else {
            boolean check = true;
            for (Facility key:facilitySet) {
                if (facility.equals(key)){
                    maintenanceCheck(key);
                    facilities.put(key,facilities.get(key)+1);
                    check = false;
                    break;
                }
            }
            if (check){
                facilities.put(facility,1);
            }
        }
    }

    @Override
    public void addHouse() {
        System.out.print("Enter serviceCode: ");
        String serviceCode = scanner.nextLine();
        while (!ValidateVila.isMatchesServiceCode(serviceCode)){
            System.out.println("service code malformed!");
            serviceCode = scanner.nextLine();
        }
        System.out.print("enter serviceName: ");
        String serviceName = scanner.nextLine();
        while (!ValidateFacility.isMatchesServiceName(serviceName)){
            System.out.println("service code malformed!");
            serviceName = scanner.nextLine();
        }
        System.out.print("enter usableArea: ");
        String usableArea = scanner.nextLine();
        System.out.print("enter rentalCosts: ");
        Double rentalCosts = Double.parseDouble(scanner.nextLine());
        System.out.print("enter maximumPerson: ");
        int maximumPerson = Integer.parseInt(scanner.nextLine());
        System.out.print("enter rentalType: ");
        String rentalType = scanner.nextLine();
        System.out.print("enter roomStandard: ");
        String roomStandard = scanner.nextLine();
        System.out.print("enter swimmingPoolArea: ");
        Double swimmingPoolArea = Double.parseDouble(scanner.nextLine());
        System.out.print("enter numberOfFloors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Vila vila = new Vila(serviceCode,serviceName, usableArea, rentalCosts, maximumPerson, rentalType, roomStandard,
                swimmingPoolArea, numberOfFloors);
        facilities.put(vila,null);

    }

    @Override
    public void addRoom() {
        System.out.print("Enter serviceCode: ");
        String serviceCode = scanner.nextLine();
        while (!ValidateRom.isMatchesServiceCode(serviceCode)){
            System.out.println("service code malformed!");
            serviceCode = scanner.nextLine();
        }
        System.out.print("enter serviceName: ");
        String serviceName = scanner.nextLine();
        while (!ValidateFacility.isMatchesServiceName(serviceName)){
            System.out.println("service code malformed!");
            serviceName = scanner.nextLine();
        }
        System.out.print("enter usableArea: ");
        String usableArea = scanner.nextLine();
        System.out.print("enter rentalCosts: ");
        Double rentalCosts = Double.parseDouble(scanner.nextLine());
        System.out.print("enter maximumPerson: ");
        int maximumPerson = Integer.parseInt(scanner.nextLine());
        System.out.print("enter rentalType: ");
        String rentalType = scanner.nextLine();
        System.out.print("enter freeServiceAttached: ");
        String freeServiceAttached = scanner.nextLine();
        Room room = new Room(serviceCode,serviceName, usableArea, rentalCosts, maximumPerson, rentalType, freeServiceAttached);
        facilities.put(room, null);
    }

    @Override
    public void addVila() {
        System.out.print("Enter serviceCode: ");
        String serviceCode = scanner.nextLine();
        while (!ValidateHouse.isMatchesServiceCode(serviceCode)){
            System.out.println("service code malformed!");
            serviceCode = scanner.nextLine();
        }
        System.out.print("enter serviceName: ");
        String serviceName = scanner.nextLine();
        while (!ValidateFacility.isMatchesServiceName(serviceName)){
            System.out.println("service code malformed!");
            serviceName = scanner.nextLine();
        }

        System.out.print("enter usableArea: ");
        String usableArea = scanner.nextLine();
        System.out.print("enter rentalCosts: ");
        Double rentalCosts = Double.parseDouble(scanner.nextLine());
        System.out.print("enter maximumPerson: ");
        int maximumPerson = Integer.parseInt(scanner.nextLine());
        System.out.print("enter rentalType: ");
        String rentalType = scanner.nextLine();
        System.out.print("enter roomStandard: ");
        String roomStandard = scanner.nextLine();
        System.out.print("enter swimmingPoolArea: ");
        Double swimmingPoolArea = Double.parseDouble(scanner.nextLine());
        System.out.print("enter numberOfFloors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());

        Vila vila = new Vila(serviceCode,serviceName, usableArea, rentalCosts, maximumPerson, rentalType, roomStandard, swimmingPoolArea,
                numberOfFloors);
        facilities.put(vila, null);
    }

    @Override
    public void displayListFacilityMaintenance() {
        for (Facility facility:maintenancefacilities) {
            System.out.println(facility);
        }

    }

    @Override
    public void maintenanceCheck(Facility facility) {
        if (facilities.get(facility)>=5){
            System.out.println("Service is under maintenance!");
            maintenancefacilities.add(facility);
            facilities.put(facility,0);
        }
    }
    @Override
    public void edit() {

    }
    @Override
    public void add() {

    }

}
