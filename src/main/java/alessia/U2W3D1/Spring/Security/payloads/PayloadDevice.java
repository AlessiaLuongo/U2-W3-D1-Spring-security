package alessia.U2W3D1.Spring.Security.payloads;

import jakarta.validation.constraints.NotEmpty;

public record PayloadDevice(

        @NotEmpty(message = "The device must have a status")
        String status,

        @NotEmpty(message = "You must specify what type of device it is")
        String type
) {
}
