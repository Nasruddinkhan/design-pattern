package com.mypractice.oops.hospital;

import java.time.*;
import java.util.*;

enum Department { ER, ICU, OPD, RADIOLOGY, LAB }
enum Specialty { GENERAL, CARDIOLOGY, NEUROLOGY, PEDIATRICS, ORTHOPEDICS }

abstract class Person {
    String id;
    String name;
    LocalDate dob;
    ContactInfo contact;
}

class ContactInfo {
    String email;
    String phone;
    String address;

    ContactInfo(String email, String phone, String address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}

class Doctor extends Person {
    Set<Specialty> specialties;
    Schedule schedule;

    Doctor(String id, String name, LocalDate dob, ContactInfo contact, Set<Specialty> specialties) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.specialties = specialties;
        this.schedule = new Schedule();
    }
}

class Nurse extends Person {
    Department department;

    Nurse(String id, String name, LocalDate dob, ContactInfo contact, Department dept) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.department = dept;
    }
}

class Patient extends Person {
    String recordNumber;
    MedicalRecord medicalRecord = new MedicalRecord();
    BillingAccount billingAccount = new BillingAccount();

    Patient(String id, String name, LocalDate dob, ContactInfo contact, String recordNumber) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.recordNumber = recordNumber;
    }
}

// ───────── appointments & schedule ─────────

class Schedule {
    Map<DayOfWeek, List<TimeSlot>> availability = new HashMap<>();
}

class TimeSlot {
    String from;
    String to;

    TimeSlot(String from, String to) {
        this.from = from;
        this.to = to;
    }
}

class Appointment {
    String id;
    Patient patient;
    Doctor doctor;
    LocalDate date;
    String time;
    AppointmentStatus status;

    Appointment(String id, Patient patient, Doctor doctor, LocalDate date, String time, AppointmentStatus status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = status;
    }
}

enum AppointmentStatus { SCHEDULED, COMPLETED, CANCELLED }

// ───────── medical record & visits ─────────

class MedicalRecord {
    List<Visit> visits = new ArrayList<>();
    List<Allergy> allergies = new ArrayList<>();
    List<MedicationOrder> currentMedications = new ArrayList<>();
}

class Visit {
    LocalDate date;
    String reason;
    Doctor attendingDoctor;
    List<Diagnosis> diagnoses;
    List<Procedure> procedures;

    Visit(LocalDate date, String reason, Doctor doctor, List<Diagnosis> dx, List<Procedure> proc) {
        this.date = date;
        this.reason = reason;
        this.attendingDoctor = doctor;
        this.diagnoses = dx;
        this.procedures = proc;
    }
}

class Allergy {
    String substance;
    String reaction;
    String severity;

    Allergy(String substance, String reaction, String severity) {
        this.substance = substance;
        this.reaction = reaction;
        this.severity = severity;
    }
}

class MedicationOrder {
    String id;
    String drugName;
    double dose;
    String frequency;
    Doctor prescribedBy;

    MedicationOrder(String id, String drugName, double dose, String frequency, Doctor prescribedBy) {
        this.id = id;
        this.drugName = drugName;
        this.dose = dose;
        this.frequency = frequency;
        this.prescribedBy = prescribedBy;
    }
}

class Diagnosis {
    String code;
    String description;

    Diagnosis(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

class Procedure {
    String name;
    String code;
    String outcome;

    Procedure(String name, String code, String outcome) {
        this.name = name;
        this.code = code;
        this.outcome = outcome;
    }
}

// ───────── lab & reports ─────────

class LabOrder {
    String id;
    LabTestType testType;
    Patient patient;
    Doctor orderedBy;
    LabResult result;

    LabOrder(String id, LabTestType type, Patient p, Doctor d) {
        this.id = id;
        this.testType = type;
        this.patient = p;
        this.orderedBy = d;
    }
}

enum LabTestType { BLOOD, URINE, XRAY, MRI, ECG }

class LabResult {
    LabOrder order;
    String findings;
    LocalDate reportedDate;

    LabResult(LabOrder order, String findings, LocalDate date) {
        this.order = order;
        this.findings = findings;
        this.reportedDate = date;
    }
}

// ───────── billing & insurance ─────────

class BillingAccount {
    List<Charge> charges = new ArrayList<>();
    List<Payment> payments = new ArrayList<>();
    BillingStrategy strategy = new InsuranceBillingStrategy();

    double getOutstandingBalance() {
        return strategy.calculate(charges, payments);
    }
}

class Charge {
    String description;
    double amount;
    LocalDate date;

    Charge(String description, double amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }
}

class Payment {
    double amount;
    LocalDate date;
    String method;

    Payment(double amount, LocalDate date, String method) {
        this.amount = amount;
        this.date = date;
        this.method = method;
    }
}

interface BillingStrategy {
    double calculate(List<Charge> charges, List<Payment> payments);
}

class InsuranceBillingStrategy implements BillingStrategy {
    public double calculate(List<Charge> charges, List<Payment> payments) {
        double total = charges.stream().mapToDouble(c -> c.amount * 0.8).sum(); // 20% discount
        double paid = payments.stream().mapToDouble(p -> p.amount).sum();
        return total - paid;
    }
}

class SelfPayBillingStrategy implements BillingStrategy {
    public double calculate(List<Charge> charges, List<Payment> payments) {
        double total = charges.stream().mapToDouble(c -> c.amount).sum();
        double paid = payments.stream().mapToDouble(p -> p.amount).sum();
        return total - paid;
    }
}
public class HospitalTest {
    public static void main(String[] args) {
        Doctor doc = new Doctor("D1", "Dr. Strange", LocalDate.of(1970, 1, 1), new ContactInfo("dr@hospital.com", "9990001111", "123 Magic St"), Set.of(Specialty.NEUROLOGY));
        Patient pat = new Patient("P1", "John Doe", LocalDate.of(1990, 2, 2), new ContactInfo("john@example.com", "8888888888", "456 Elm St"), "REC123");

        Appointment appt = new Appointment("A1", pat, doc, LocalDate.now(), "10:00", AppointmentStatus.SCHEDULED);

        Diagnosis dx = new Diagnosis("J00", "Common Cold");
        Procedure proc = new Procedure("Throat Swab", "PRC001", "Completed");
        Visit visit = new Visit(LocalDate.now(), "Cough", doc, List.of(dx), List.of(proc));
        pat.medicalRecord.visits.add(visit);

        Allergy allergy = new Allergy("Penicillin", "Rash", "High");
        pat.medicalRecord.allergies.add(allergy);

        MedicationOrder med = new MedicationOrder("MED001", "Paracetamol", 500, "BID", doc);
        pat.medicalRecord.currentMedications.add(med);

        Charge charge = new Charge("Consultation", 200, LocalDate.now());
        pat.billingAccount.charges.add(charge);
        Payment payment = new Payment(100, LocalDate.now(), "Credit Card");
        pat.billingAccount.payments.add(payment);

        System.out.println("Outstanding Balance: " + pat.billingAccount.getOutstandingBalance());
        System.out.println("Visit Reason: " + visit.reason);
        System.out.println("Diagnosis: " + dx.description);
    }
}
