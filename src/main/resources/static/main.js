// -------------------------------
// UTILITY: Safe query helper
// -------------------------------
function $(selector) {
    return document.querySelector(selector);
}

function $all(selector) {
    return document.querySelectorAll(selector);
}



// -------------------------------
// ADD ROW ANIMATION
// -------------------------------
function animateNewRows() {
    const newRows = $all("tr[data-new='true']");

    newRows.forEach(row => {
        row.classList.add("table-row-animate");

        setTimeout(() => {
            row.classList.remove("table-row-animate");
            row.removeAttribute("data-new");
        }, 400);
    });
}



// -------------------------------
// DELETE ROW ANIMATION
// -------------------------------
function setupDeleteButtons() {
    const deleteButtons = $all(".delete-btn");

    deleteButtons.forEach(btn => {
        btn.addEventListener("click", event => {
            event.preventDefault();

            const row = btn.closest("tr");
            if (!row) return;

            // Capture height for collapse animation
            const height = row.offsetHeight;
            row.style.setProperty("--row-height", height + "px");

            row.classList.add("table-row-remove");

            // Wait for animation to finish
            setTimeout(() => {
                const form = btn.closest("form");
                if (form) form.submit();
            }, 600); // match your animation duration
        });
    });
}



// -------------------------------
// ADD ROW BUTTONS (Spring handles actual add)
// -------------------------------
function setupAddRowButtons() {
    const addButtons = $all(".add-row-btn");

    addButtons.forEach(btn => {
        btn.addEventListener("click", event => {
            event.preventDefault();

            const form = btn.closest("form");
            if (form) form.submit();
        });
    });
}



// -------------------------------
// MODAL: OPEN & CLOSE
// -------------------------------
function setupModal() {
    const openBtn = $("#billsAddRowBtn");
    const modal = $("#addBillModal");
    const cancelBtn = $(".modal-cancel");

    if (!modal) {
        console.warn("Modal element #addBillModal not found.");
        return;
    }

    if (openBtn) {
        openBtn.addEventListener("click", () => {
            modal.style.display = "flex";
        });
    } else {
        console.warn("Add Row button #billsAddRowBtn not found.");
    }

    if (cancelBtn) {
        cancelBtn.addEventListener("click", () => {
            modal.style.display = "none";
        });
    } else {
        console.warn("Modal cancel button not found.");
    }
}



// -------------------------------
// INITIALIZE EVERYTHING
// -------------------------------
document.addEventListener("DOMContentLoaded", () => {
    console.log("JS loaded and DOM ready.");

    setupDeleteButtons();
    setupAddRowButtons();
    animateNewRows();
    setupModal();
});