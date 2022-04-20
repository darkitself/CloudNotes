package com.example.demo.domain.enums;

public enum UserRole {
    OWNER(true, true, true),
    EDITOR(true, true, false),
    VIEWER(true, false, false);

    final Boolean canEdit;
    final Boolean canView;
    final Boolean canDelete;

    UserRole( Boolean canView,Boolean canEdit, Boolean canDelete) {
        this.canEdit = canEdit;
        this.canView = canView;
        this.canDelete = canDelete;
    }

    public Boolean canEdit() {
        return canEdit;
    }

    public Boolean canView() {
        return canView;
    }

    public Boolean canDelete() {
        return canDelete;
    }
}
