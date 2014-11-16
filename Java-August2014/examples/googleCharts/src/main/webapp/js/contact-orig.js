$(document).ready(function() {

    loadContacts();

    $('#addButton').click(function() {
        $.ajax({'type': 'POST',
            'url': 'http://localhost:8080/ContactListMVC/spring/rest/contact',
            data: JSON.stringify({
                name: $('#add-name').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': "json"
        }).then(function(data, status) {
            $('#add-name').val('');
            $('#add-phone').val('');
            $('#add-email').val('');
            loadContacts();

        });
    });

    $('#editButton').click(function() {
        $.ajax({'type': 'PUT',
            'url': 'http://localhost:8080/ContactListMVC/spring/rest/contact/' + $('#edit-contactId').val(),
            data: JSON.stringify({
                name: $('#edit-name').val(),
                phone: $('#edit-phone').val(),
                email: $('#edit-email').val(),
                contactId: $('#edit-contactId').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': "json"
        }).then(function(data, status) {
            $('#edit-name').val('');
            $('#edit-phone').val('');
            $('#edit-email').val('');
            $('#edit-contactId').val('');
            loadContacts();
        });
    });

});

function deleteContact(element) {
    $.ajax({'type': 'DELETE',
        'url': 'http://localhost:8080/ContactListMVC/spring/rest/contact/' + element.getAttribute('href')
    }).then(function(status) {
        loadContacts();
    });
}

function getEditContact(element) {
    $.ajax({
        url: 'http://localhost:8080/ContactListMVC/spring/rest/contact/' + element.getAttribute("href")
    }).then(function(data) {
        $('#edit-name').val(data.name);
        $('#edit-phone').val(data.phone);
        $('#edit-email').val(data.email);
        $('#edit-contactId').val(data.contactId);
    });
}

function getContact(element) {
    $.ajax({
        url: 'http://localhost:8080/ContactListMVC/spring/rest/contact/' + element.getAttribute("href")
    }).then(function(data) {
        $('#detail-name').text('Name: ' + data.name);
        $('#detail-phone').text('Phone: ' + data.phone);
        $('#detail-email').text('Email: ' + data.email);
        $('#detail-contactId').text('Contact ID: ' + data.contactId);
    });
}

function loadContacts() {
    $('#contact-list').empty();
    $.ajax({
        url: "http://localhost:8080/ContactListMVC/spring/rest/contacts/"
    }).then(function(data, status) {
        console.log(data);
        console.log(status);
        $.each(data, function(index, contact) {
            
            $('#contact-list').append('<p><a onclick="getContact(this); return false;" href="' +
                    contact.contactId + '">' +
                    contact.firstName +  ' ' + contact.lastName + '</a> | <a onclick="getEditContact(this); return false;" href="' +
                    contact.contactId + '">Edit</a> | <a onclick="deleteContact(this); return false;" href="' +
                    contact.contactId + '">Delete</a></p>');
        });
    });
}
