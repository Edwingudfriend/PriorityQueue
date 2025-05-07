// Frontend Logic for Triage System
document.addEventListener('DOMContentLoaded', function() {
    const patientForm = document.getElementById('patientForm');
    const nextPatientBtn = document.getElementById('nextPatientBtn');
    const patientList = document.getElementById('patientList');

    // Add new patient
    patientForm.addEventListener('submit', function(e) {
        e.preventDefault();

        const patient = {
            name: document.getElementById('name').value,
            age: document.getElementById('age').value,
            symptoms: document.getElementById('symptoms').value,
            priority: document.getElementById('priority').value
        };

        fetch('/api/triage/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(patient)
        })
            .then(response => response.json())
            .then(data => {
                loadPatients();
                patientForm.reset();
            });
    });

    // Get next patient
    nextPatientBtn.addEventListener('click', function() {
        fetch('/api/triage/next')
            .then(response => response.json())
            .then(patient => {
                if (patient) {
                    alert(`Next patient: ${patient.name} (Priority: ${patient.priority})`);
                    loadPatients();
                } else {
                    alert('No patients in queue!');
                }
            });
    });

    // Load all patients
    function loadPatients() {
        fetch('/api/triage/all')
            .then(response => response.json())
            .then(patients => {
                patientList.innerHTML = '';
                patients.forEach(patient => {
                    const card = document.createElement('div');
                    card.className = `patient-card priority-${patient.priority.toLowerCase()}`;
                    card.innerHTML = `
                        <div>
                            <strong>${patient.name}</strong> (Age: ${patient.age})<br>
                            Symptoms: ${patient.symptoms}
                        </div>
                        <div>
                            Priority: ${patient.priority}
                        </div>
                    `;
                    patientList.appendChild(card);
                });
            });
    }

    // Initial load
    loadPatients();
});