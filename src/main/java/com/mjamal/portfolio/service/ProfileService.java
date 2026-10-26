package com.mjamal.portfolio.service;

import com.mjamal.portfolio.model.Profile;
import com.mjamal.portfolio.model.Profile.Certification;
import com.mjamal.portfolio.model.Profile.Education;
import com.mjamal.portfolio.model.Profile.Experience;
import com.mjamal.portfolio.model.Profile.Project;
import com.mjamal.portfolio.model.Profile.SkillGroup;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Profile data for the site, taken from the LinkedIn profile. Edit this class to update the portfolio.
 */
@Service
public class ProfileService {

    private static final String GITHUB_HANDLE = "thankyoujamal";

    private final Profile profile = new Profile(
            "Mohammad Jamal Uddin",
            "Aspiring Software Engineer",
            "Kolkata, Sector V",
            "ujamal85020@gmail.com",
            "+91 85090 02291",
            "https://www.linkedin.com/in/mdjamal-uddin",
            "https://github.com/" + GITHUB_HANDLE,
            "I build reliable, scalable and user-friendly applications with Java, Spring Boot, Python "
                    + "and modern full-stack tools, and I'm growing into AI and Machine Learning.",
            List.of(new Experience(
                    "Software Development Intern (Java)",
                    "Euphoria GenX · Kolkata, West Bengal",
                    "Dec 2023 – Apr 2024 · 5 months",
                    List.of(
                            "Completed Euphoria GenX's Skill Development and Internship Programme in Advanced Java (Certificate ID: EG_24_2102).",
                            "Built the Online Book Store project end-to-end on Java, JDBC and MySQL: user registration and login, an admin module to add, update and delete books, search, cart and order history.",
                            "Designed the relational schema (users, books, orders) and wrote the SQL for all CRUD operations.",
                            "Implemented input validation and exception handling for a stable user flow."),
                    List.of("users", "books", "orders"))),
            List.of(
                    new Project("Online Book Store", "Euphoria GenX internship · 2024",
                            "Registration and login, an admin module to add, update and delete books, search, cart and order history, "
                                    + "on a relational MySQL schema with validation and exception handling.",
                            List.of("Java", "JDBC", "MySQL", "HTML", "CSS", "JavaScript"), null)),
            List.of(
                    new SkillGroup("Programming", List.of("Java", "Python", "JavaScript")),
                    new SkillGroup("Backend", List.of("Spring Boot", "REST APIs", "JDBC")),
                    new SkillGroup("Frontend", List.of("HTML", "CSS", "JavaScript", "React")),
                    new SkillGroup("Databases", List.of("MySQL")),
                    new SkillGroup("Tools", List.of("Git", "GitHub", "VS Code", "IntelliJ IDEA", "Linux")),
                    new SkillGroup("Currently learning", List.of("AI", "Machine Learning", "Docker", "Cloud"))),
            List.of(
                    new Education("Master of Computer Applications", "Techno India University", "Jun 2022 – Aug 2024", null),
                    new Education("Bachelor of Computer Applications", "IMS Kolkata", "Jul 2019 – Apr 2022", null)),
            List.of(
                    new Certification("Industrial Training Programme on Advanced Java", null),
                    new Certification("Certificate of Internship – Online Book Store Project (Advanced Java)", null)));

    public Profile getProfile() {
        return profile;
    }
}
