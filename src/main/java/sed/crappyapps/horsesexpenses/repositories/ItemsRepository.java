/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sed.crappyapps.horsesexpenses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sed.crappyapps.horsesexpenses.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Long>{}
