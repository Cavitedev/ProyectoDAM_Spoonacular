package com.cavitedet.proyectodam_spoonacular.spoonacular;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.JsonUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class JsonDeserializationTest {


    @Test
    public void deserializeIngredient() {
        String responseJson = "{\"id\":19400, \"name\":\"banana chips\", \"image\":\"banana-chips.jpg\"}";
        Ingrediente obj = JsonUtil.deserializarIngrediente(responseJson);

        Assert.assertEquals("Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}"
                , obj.toString());
    }

    @Test
    public void deserializeIngredientList() {
        //https://spoonacular.com/food-api/docs#Search-Recipes-by-Ingredients
        String responseJson = "[{\"id\":19400,\"name\":\"banana chips\",\"image\":\"banana-chips.jpg\"},{\"id\":93779,\"name\":\"banana liqueur\",\"image\":\"limoncello.jpg\"}]";
        List<Ingrediente> obj = JsonUtil.deserializeIngredientList(responseJson);

        Assert.assertEquals("[Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}, Ingredient{id=93779, name='banana liqueur', image='limoncello.jpg'}]", obj.toString());
    }

    @Test
    public void deserializeIngredientSearch() {
        //https://spoonacular.com/food-api/docs#Search-Recipes-by-Ingredients
        String responseJson = "{\"results\":[{\"id\":19400,\"name\":\"banana chips\",\"image\":\"banana-chips.jpg\"},{\"id\":93779,\"name\":\"banana liqueur\",\"image\":\"limoncello.jpg\"}],\"offset\":0,\"number\":2,\"totalResults\":13}";
        Ingredientes obj = JsonUtil.deserializarIngredientes(responseJson);

        Assert.assertEquals("Ingredients{ingredientList=[Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}, Ingredient{id=93779, name='banana liqueur', image='limoncello.jpg'}], offset=0, number=2, totalResults=13}", obj.toString());
    }

    @Test
    public void deserializarIngredienteDetallado() {

        String esperado = "IngredienteDetallado{id=9266, original='pineapples', nombreOriginal='pineapples', nombre='pineapples', cantidad=1.0, unidadDeMedida='', unidadDeMedidaReducida='', unidadDeMedidaAlargada='', posiblesUnidades=[piece, slice, fruit, g, oz, cup, serving], valorEstimado=ValorEstimado{valor=299.0, unidad='US Cents'}, consistencia='solid', tiposDeUnidadesAlCobrar=[pieces], categoria='Produce', imagen='pineapple.jpg', metaInformacion=[], nutricion=Nutricion{nutrientes=[Nutriente{nombre='Calories', cantidad=452.5, unidad='kcal', porcentajeNecesitadoAlDia=22.63}, Nutriente{nombre='Fat', cantidad=1.09, unidad='g', porcentajeNecesitadoAlDia=1.67}, Nutriente{nombre='Saturated Fat', cantidad=0.08, unidad='g', porcentajeNecesitadoAlDia=0.51}, Nutriente{nombre='Carbohydrates', cantidad=118.74, unidad='g', porcentajeNecesitadoAlDia=39.58}, Nutriente{nombre='Net Carbohydrates', cantidad=106.07, unidad='g', porcentajeNecesitadoAlDia=38.57}, Nutriente{nombre='Sugar', cantidad=89.14, unidad='g', porcentajeNecesitadoAlDia=99.05}, Nutriente{nombre='Cholesterol', cantidad=0.0, unidad='mg', porcentajeNecesitadoAlDia=0.0}, Nutriente{nombre='Sodium', cantidad=9.05, unidad='mg', porcentajeNecesitadoAlDia=0.39}, Nutriente{nombre='Protein', cantidad=4.89, unidad='g', porcentajeNecesitadoAlDia=9.77}, Nutriente{nombre='Vitamin C', cantidad=432.59, unidad='mg', porcentajeNecesitadoAlDia=524.35}, Nutriente{nombre='Manganese', cantidad=8.39, unidad='mg', porcentajeNecesitadoAlDia=419.47}, Nutriente{nombre='Fiber', cantidad=12.67, unidad='g', porcentajeNecesitadoAlDia=50.68}, Nutriente{nombre='Vitamin B6', cantidad=1.01, unidad='mg', porcentajeNecesitadoAlDia=50.68}, Nutriente{nombre='Copper', cantidad=1.0, unidad='mg', porcentajeNecesitadoAlDia=49.78}, Nutriente{nombre='Vitamin B1', cantidad=0.72, unidad='mg', porcentajeNecesitadoAlDia=47.66}, Nutriente{nombre='Folate', cantidad=162.9, unidad='µg', porcentajeNecesitadoAlDia=40.73}, Nutriente{nombre='Potassium', cantidad=986.45, unidad='mg', porcentajeNecesitadoAlDia=28.18}, Nutriente{nombre='Magnesium', cantidad=108.6, unidad='mg', porcentajeNecesitadoAlDia=27.15}, Nutriente{nombre='Vitamin B3', cantidad=4.53, unidad='mg', porcentajeNecesitadoAlDia=22.63}, Nutriente{nombre='Vitamin B5', cantidad=1.93, unidad='mg', porcentajeNecesitadoAlDia=19.28}, Nutriente{nombre='Vitamin B2', cantidad=0.29, unidad='mg', porcentajeNecesitadoAlDia=17.04}, Nutriente{nombre='Iron', cantidad=2.62, unidad='mg', porcentajeNecesitadoAlDia=14.58}, Nutriente{nombre='Calcium', cantidad=117.65, unidad='mg', porcentajeNecesitadoAlDia=11.77}, Nutriente{nombre='Vitamin A', cantidad=524.9, unidad='IU', porcentajeNecesitadoAlDia=10.5}, Nutriente{nombre='Phosphorus', cantidad=72.4, unidad='mg', porcentajeNecesitadoAlDia=7.24}, Nutriente{nombre='Zinc', cantidad=1.09, unidad='mg', porcentajeNecesitadoAlDia=7.24}, Nutriente{nombre='Vitamin K', cantidad=6.34, unidad='µg', porcentajeNecesitadoAlDia=6.03}, Nutriente{nombre='Selenium', cantidad=0.91, unidad='µg', porcentajeNecesitadoAlDia=1.29}, Nutriente{nombre='Vitamin E', cantidad=0.18, unidad='mg', porcentajeNecesitadoAlDia=1.21}], propiedades=[Propiedades{nombre='Glycemic Index', cantidad=58.67, unidad=''}, Propiedades{nombre='Glycemic Load', cantidad=62.23, unidad=''}], descomposicionCalorica=DescomposicionCalorica{porcentajeProteinas=3.88, porcentajeGrasas=null, porcentajeCarbohidratos=94.18}, pesoPorRacion=PesoUnidad{cantidad=905.0, unidad='g'}}, caminoDeCategorias=[tropical fruit, fruit]}";
        String responseJson = "{\"id\":9266,\"original\":\"pineapples\",\"originalName\":\"pineapples\",\"name\":\"pineapples\",\"amount\":1.0,\"unit\":\"\",\"unitShort\":\"\",\"unitLong\":\"\",\"possibleUnits\":[\"piece\",\"slice\",\"fruit\",\"g\",\"oz\",\"cup\",\"serving\"],\"estimatedCost\":{\"value\":299.0,\"unit\":\"US Cents\"},\"consistency\":\"solid\",\"shoppingListUnits\":[\"pieces\"],\"aisle\":\"Produce\",\"image\":\"pineapple.jpg\",\"meta\":[],\"nutrition\":{\"nutrients\":[{\"title\":\"Calories\",\"amount\":452.5,\"unit\":\"kcal\",\"percentOfDailyNeeds\":22.63},{\"title\":\"Fat\",\"amount\":1.09,\"unit\":\"g\",\"percentOfDailyNeeds\":1.67},{\"title\":\"Saturated Fat\",\"amount\":0.08,\"unit\":\"g\",\"percentOfDailyNeeds\":0.51},{\"title\":\"Carbohydrates\",\"amount\":118.74,\"unit\":\"g\",\"percentOfDailyNeeds\":39.58},{\"title\":\"Net Carbohydrates\",\"amount\":106.07,\"unit\":\"g\",\"percentOfDailyNeeds\":38.57},{\"title\":\"Sugar\",\"amount\":89.14,\"unit\":\"g\",\"percentOfDailyNeeds\":99.05},{\"title\":\"Cholesterol\",\"amount\":0.0,\"unit\":\"mg\",\"percentOfDailyNeeds\":0.0},{\"title\":\"Sodium\",\"amount\":9.05,\"unit\":\"mg\",\"percentOfDailyNeeds\":0.39},{\"title\":\"Protein\",\"amount\":4.89,\"unit\":\"g\",\"percentOfDailyNeeds\":9.77},{\"title\":\"Vitamin C\",\"amount\":432.59,\"unit\":\"mg\",\"percentOfDailyNeeds\":524.35},{\"title\":\"Manganese\",\"amount\":8.39,\"unit\":\"mg\",\"percentOfDailyNeeds\":419.47},{\"title\":\"Fiber\",\"amount\":12.67,\"unit\":\"g\",\"percentOfDailyNeeds\":50.68},{\"title\":\"Vitamin B6\",\"amount\":1.01,\"unit\":\"mg\",\"percentOfDailyNeeds\":50.68},{\"title\":\"Copper\",\"amount\":1.0,\"unit\":\"mg\",\"percentOfDailyNeeds\":49.78},{\"title\":\"Vitamin B1\",\"amount\":0.72,\"unit\":\"mg\",\"percentOfDailyNeeds\":47.66},{\"title\":\"Folate\",\"amount\":162.9,\"unit\":\"µg\",\"percentOfDailyNeeds\":40.73},{\"title\":\"Potassium\",\"amount\":986.45,\"unit\":\"mg\",\"percentOfDailyNeeds\":28.18},{\"title\":\"Magnesium\",\"amount\":108.6,\"unit\":\"mg\",\"percentOfDailyNeeds\":27.15},{\"title\":\"Vitamin B3\",\"amount\":4.53,\"unit\":\"mg\",\"percentOfDailyNeeds\":22.63},{\"title\":\"Vitamin B5\",\"amount\":1.93,\"unit\":\"mg\",\"percentOfDailyNeeds\":19.28},{\"title\":\"Vitamin B2\",\"amount\":0.29,\"unit\":\"mg\",\"percentOfDailyNeeds\":17.04},{\"title\":\"Iron\",\"amount\":2.62,\"unit\":\"mg\",\"percentOfDailyNeeds\":14.58},{\"title\":\"Calcium\",\"amount\":117.65,\"unit\":\"mg\",\"percentOfDailyNeeds\":11.77},{\"title\":\"Vitamin A\",\"amount\":524.9,\"unit\":\"IU\",\"percentOfDailyNeeds\":10.5},{\"title\":\"Phosphorus\",\"amount\":72.4,\"unit\":\"mg\",\"percentOfDailyNeeds\":7.24},{\"title\":\"Zinc\",\"amount\":1.09,\"unit\":\"mg\",\"percentOfDailyNeeds\":7.24},{\"title\":\"Vitamin K\",\"amount\":6.34,\"unit\":\"µg\",\"percentOfDailyNeeds\":6.03},{\"title\":\"Selenium\",\"amount\":0.91,\"unit\":\"µg\",\"percentOfDailyNeeds\":1.29},{\"title\":\"Vitamin E\",\"amount\":0.18,\"unit\":\"mg\",\"percentOfDailyNeeds\":1.21}],\"properties\":[{\"title\":\"Glycemic Index\",\"amount\":58.67,\"unit\":\"\"},{\"title\":\"Glycemic Load\",\"amount\":62.23,\"unit\":\"\"}],\"flavanoids\":[{\"title\":\"Cyanidin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Petunidin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Delphinidin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Malvidin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Pelargonidin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Peonidin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Catechin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Epigallocatechin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Epicatechin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Epicatechin 3-gallate\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Epigallocatechin 3-gallate\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Theaflavin\",\"amount\":0.0,\"unit\":\"\"},{\"title\":\"Thearubigins\",\"amount\":0.0,\"unit\":\"\"},{\"title\":\"Eriodictyol\",\"amount\":0.0,\"unit\":\"\"},{\"title\":\"Hesperetin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Naringenin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Apigenin\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Luteolin\",\"amount\":0.09,\"unit\":\"mg\"},{\"title\":\"Isorhamnetin\",\"amount\":0.0,\"unit\":\"\"},{\"title\":\"Kaempferol\",\"amount\":0.0,\"unit\":\"mg\"},{\"title\":\"Myricetin\",\"amount\":0.09,\"unit\":\"mg\"},{\"title\":\"Quercetin\",\"amount\":1.27,\"unit\":\"mg\"},{\"title\":\"Theaflavin-3,3'-digallate\",\"amount\":0.0,\"unit\":\"\"},{\"title\":\"Theaflavin-3'-gallate\",\"amount\":0.0,\"unit\":\"\"},{\"title\":\"Theaflavin-3-gallate\",\"amount\":0.0,\"unit\":\"\"},{\"title\":\"Gallocatechin\",\"amount\":0.0,\"unit\":\"mg\"}],\"caloricBreakdown\":{\"percentProtein\":3.88,\"percentFat\":1.94,\"percentCarbs\":94.18},\"weightPerServing\":{\"amount\":905,\"unit\":\"g\"}},\"categoryPath\":[\"tropical fruit\",\"fruit\"]}";
        IngredienteDetallado ingredienteDetallado = JsonUtil.deserializarIngredienteDetallado(responseJson);

        Assert.assertEquals(esperado, ingredienteDetallado.toString());
    }

}
