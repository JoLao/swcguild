/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.model;

import java.util.Arrays;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author klove
 */
public class ProductItem {
    private int productItemId;

    private int productId;

    @NotNull
    @Size(min=2,max=30,message="Product item name must be between 2 and 30 characters in length")
    private String productItemName;
    private boolean checkedOut;
    private boolean damaged;

    private boolean lost;

    private boolean active;

    private int[] noteIds;

    public int getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(int productItemId) {
        this.productItemId = productItemId;
    }

    public String getProductItemName() {
        return productItemName;
    }

    public void setProductItemName(String productItemName) {
        this.productItemName = productItemName;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int[] getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(int[] noteIds) {
        this.noteIds = noteIds;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.productItemId;
        hash = 31 * hash + Objects.hashCode(this.productItemName);
        hash = 31 * hash + (this.checkedOut ? 1 : 0);
        hash = 31 * hash + (this.damaged ? 1 : 0);
        hash = 31 * hash + (this.active ? 1 : 0);
        hash = 31 * hash + Arrays.hashCode(this.noteIds);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductItem other = (ProductItem) obj;
        if (this.productItemId != other.productItemId) {
            return false;
        }
        if (!Objects.equals(this.productItemName, other.productItemName)) {
            return false;
        }
        if (this.checkedOut != other.checkedOut) {
            return false;
        }
        if (this.damaged != other.damaged) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Arrays.equals(this.noteIds, other.noteIds)) {
            return false;
        }
        return true;
    }
}
