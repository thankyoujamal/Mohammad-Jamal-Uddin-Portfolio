package com.mjamal.portfolio.model;

import java.util.List;

/**
 * Everything shown on the portfolio page. Built once by {@link com.mjamal.portfolio.service.ProfileService}.
 */
public record Profile(
        String name,
        String title,
        String location,
        String email,
        String phone,
        String linkedin,
        String github,
        String summary,
        List<Experience> experience,
        List<Project> projects,
        List<SkillGroup> skills,
        List<Education> education,
        List<Certification> certifications) {

    public record Experience(String role, String company, String period, List<String> highlights, List<String> flow) {
    }

    public record Project(String name, String context, String description, List<String> stack, String link) {
    }

    public record SkillGroup(String category, List<String> items) {
    }

    public record Education(String degree, String institute, String period, String cgpa) {
    }

    public record Certification(String name, String period) {
    }
}
