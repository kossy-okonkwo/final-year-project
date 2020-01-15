package com.isoft.event;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by mac on 15/12/2019.
 */
public class ModifyEventCmd {
	private Long id;
	@NotBlank
	private String eventTitle;
	@NotBlank
	private String eventDetails;
	@NotNull
	private LocalDate eventDate;
}
