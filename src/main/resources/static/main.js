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
    const modals = [
        { open: "#billsAddRowBtn", modal: "#addBillModal" },
        { open: "#itemsAddRowBtn", modal: "#addItemModal" },
        { open: "#employeesAddRowBtn", modal: "#addEmployeeModal" }
        { open: "#incomeAddRowBtn", modal: "#addIncomeModal" }
    ];

    // Attach open handlers
    modals.forEach(pair => {
        const openBtn = $(pair.open);
        const modal = $(pair.modal);

        if (openBtn && modal) {
            openBtn.addEventListener("click", () => {
                modal.style.display = "flex";
            });
        }
    });

    // Attach close handlers (shared)
    const cancelButtons = $all(".modal-cancel");
    cancelButtons.forEach(btn => {
        btn.addEventListener("click", () => {
            const modal = btn.closest(".modal-overlay");
            if (modal) modal.style.display = "none";
        });
    });
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